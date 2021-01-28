package sorting;

import java.util.ArrayList;
import java.util.HashSet;

public interface Sorter {
    public ArrayList<String> getWords(String[] words, int numberOfLetters);

    public HashSet<String> getSubwords(String[] words, int maxAmountOfLetters);
}
