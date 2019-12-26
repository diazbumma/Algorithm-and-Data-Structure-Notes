package sorting;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] myArray = {7, 14, 3, 5, 13, 10, 11, 6, 9, 4, 1, 8, 12, 2, 15};
        shellSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    public static void shellSort(int[] intArray) {
        int size = intArray.length;
        int gap = size/2;

        for (int i = gap; i < size; i++) {
            int temp = intArray[i];
            int key = i;

            while (key >= gap && temp < intArray[key-gap]) {
                intArray[key] = intArray[key-gap];
                key -= gap;
            }

            intArray[key] = temp;

            if (i == size-1 && gap > 1) {
                gap /= 2;
                i = gap-1;
            }
        }
    }
}
