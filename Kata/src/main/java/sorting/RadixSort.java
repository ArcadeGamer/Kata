package sorting;

import java.util.Arrays;

public class RadixSort {

    private int getMax(String words[]) {
        int maxWordLength = words[0].length();
        for (int i = 1; i < words.length; i++)
            if (words[i].length() > maxWordLength)
                maxWordLength = words[i].length();
        return maxWordLength;
    }


    private void countSort(String words[], int exponent) {
        int arraySize = words.length;
        String output[] = new String[arraySize];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < arraySize; i++)
            count[(words[i].length() / exponent) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = arraySize - 1; i >= 0; i--) {
            output[count[(words[i].length() / exponent) % 10] - 1] = words[i];
            count[(words[i].length() / exponent) % 10]--;
        }

        for (int i = 0; i < arraySize; i++)
            words[i] = output[i];
    }

    public void sort(String words[])  {
        int maxWordLength = getMax(words);

        for (int lenghth_exponent = 1; maxWordLength / lenghth_exponent > 0; lenghth_exponent *= 10)
            countSort(words, lenghth_exponent);
    }
}
