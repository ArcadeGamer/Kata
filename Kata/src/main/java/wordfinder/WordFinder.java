package wordfinder;

import sorting.RadixSort;
import sorting.Sorter;
import wordLogger.WordLogger;
import wordfetcher.WordFetcher;

import java.util.ArrayList;
import java.util.HashSet;

public class WordFinder {
    private WordFetcher wordFetcher;
    private Sorter wordSorter;
    private String[] words;
    private WordLogger logger;

    private ArrayList<Integer> wordIndexes = new ArrayList<Integer>(); // Juste utiliser pour l'ancien code

    public WordFinder(WordFetcher wordFetcher, Sorter wordSorter, WordLogger wordLogger) {
        this.wordFetcher = wordFetcher;
        this.wordSorter = wordSorter;
        this.logger = wordLogger;
    }

    public void findAllComposedWords(int numberOfLetters){
        words = wordFetcher.getWords();
        ArrayList<String> potentialWords = wordSorter.getWords(words, numberOfLetters);
        HashSet<String> subwords = wordSorter.getSubwords(words, numberOfLetters);

        for (String word : potentialWords) {
            for (int i = 1; i < numberOfLetters; i++) {
                String firstSubword = word.substring(0, i);
                String secondSubword = word.substring(i, numberOfLetters);
                if (subwords.contains(firstSubword) && subwords.contains(secondSubword)) {
                    logger.displayResult(firstSubword, secondSubword, word);
                }
            }
        }
    }

    // ########################
    // SECTION JUSTE POUR DEMO
    // ########################

    private void oldComposedWordMethod(int numberOfLetters) {
        words = wordFetcher.getWords();
        RadixSort radixSort = new RadixSort();
        radixSort.sort(words);

        getIndexOfFirstWordOfEachLength();

        for (int i = wordIndexes.get(numberOfLetters - 1); i < wordIndexes.get(numberOfLetters); i++) {
            String currentWord = words[i];

            for (int j = 0; j < wordIndexes.get(numberOfLetters - 1); j++) {
                String potentialSmallerWord = words[j];
                if (potentialSmallerWord.equals(currentWord.substring(0, potentialSmallerWord.length()))) {
                    int lettersLeft = numberOfLetters - potentialSmallerWord.length();

                    for (int z = wordIndexes.get(lettersLeft - 1); z < wordIndexes.get(lettersLeft); z++) {
                        String otherPotentialHalfWord = words[z];

                        if (potentialSmallerWord.concat(otherPotentialHalfWord).equals(currentWord)) {
                          logger.displayResult(potentialSmallerWord, otherPotentialHalfWord, currentWord);
                          j = wordIndexes.get(potentialSmallerWord.length());
                          break;
                        }
                    }
                }
            }
        }
    }

    private void getIndexOfFirstWordOfEachLength() {
        int previousWordLength = 0;

        for (int i = 0; i < words.length; i++) {
            if(words[i].length() > previousWordLength) {
                previousWordLength = words[i].length();
                wordIndexes.add(i);
            }
        }
    }
}
