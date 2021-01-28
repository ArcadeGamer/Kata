package sorting;

import java.util.ArrayList;
import java.util.HashSet;

public class WordSorter implements Sorter { // TODO : Pourrait être dans le WordFetcher?
    public ArrayList<String> getWords(String[] words, int numberOfLetters) {
        ArrayList<String> possibleWords = new ArrayList<String>();

        for(String word: words) {
            if (word.length() == numberOfLetters) {
                possibleWords.add(word);
            }
        }
        return possibleWords;
    }

    public HashSet<String> getSubwords(String[] words, int maxAmountOfLetters) {
        HashSet<String> possibleSubwords = new HashSet<String>();

        for(String word: words) {
            if (word.length() < maxAmountOfLetters) {
                possibleSubwords.add(word);
            }
        }
        return possibleSubwords;
    }
}
