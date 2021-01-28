package wordfinder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import sorting.Sorter;
import wordLogger.WordLogger;
import wordfetcher.WordFetcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WordFinderTest {

    @Mock private WordFetcher wordFetcher;
    @Mock private WordLogger wordLogger;
    @Mock private Sorter wordSorter;

    private WordFinder wordFinder;


    private static final int NUMBEROFLETTERS = 7;
    private static final String[] WORDARRAY = {"a","b", "bon", "jour", "ttt", "asdwasj", "bonjour", "aaatttt"};
    private static final ArrayList<String> WHOLEWORDS = new ArrayList<String>(Arrays.asList("asdwasj", "bonjour", "aaatttt"));
    private static final HashSet<String> SUBWORDS = new HashSet<String>(Arrays.asList("a","b", "bon", "jour", "ttt"));

    @Before
    public void setup() {
        wordFinder = new WordFinder(wordFetcher, wordSorter, wordLogger);

        when(wordFetcher.getWords()).thenReturn(WORDARRAY);
        when(wordSorter.getWords(WORDARRAY, NUMBEROFLETTERS)).thenReturn(WHOLEWORDS);
        when(wordSorter.getSubwords(WORDARRAY, NUMBEROFLETTERS)).thenReturn(SUBWORDS);
    }

    @Test
    public void whenFindingSubwords_thenShouldCallWordFetcher() {
        wordFinder.findAllComposedWords(NUMBEROFLETTERS);
        verify(wordFetcher).getWords();
    }

    @Test
    public void whenFindingSubwords_thenShouldFindAllSubwords() {
        wordFinder.findAllComposedWords(NUMBEROFLETTERS);
        verify(wordLogger).displayResult("bon", "jour", "bonjour");
    }

    @Test
    public void whenFindingSubwords_thenShouldCallWordLogger() {
        wordFinder.findAllComposedWords(NUMBEROFLETTERS);
        verify(wordLogger).displayResult("bon", "jour", "bonjour");
    }
}