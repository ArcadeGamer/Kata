package sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RadixSortTest {

    private RadixSort radixSort;

    @Before
    public void setup() {
        radixSort = new RadixSort();
    }

    @Test
    public void givenAnArrayOfStrings_thenShouldReturnStringsInProperOrder() {
        String[] strings = {"a", "ab", "bon", "bien", "beaucoup", "c", "compris", "destiny", "des"};
        String[] expectedStrings = {"a", "c", "ab", "bon", "des", "bien", "compris", "destiny", "beaucoup"}; // TODO : Test fragile

        radixSort.sort(strings);

        assertArrayEquals(expectedStrings, strings);
    }

}