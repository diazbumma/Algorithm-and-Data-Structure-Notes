package sorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] intArray = {7, 14, 3, 5, 13, 10, 11, 6, 9, 4, 1, 8, 12, 2, 15};
        countingSort(intArray);
        System.out.println(Arrays.toString(intArray));
    }

    public static void countingSort(int[] arr) {
        // assuming max possible value in array is 100
        int[] count = new int[101];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int arrIndex = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                arr[arrIndex++] = i;
                count[i]--;
            }
        }
    }
}
