package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] myArray = {7, 14, 3, 5, 13, 10, 11, 6, 9, 4, 1, 8, 12, 2, 15};
        bubbleSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    public static void bubbleSort(int[] arr) {
        int i = 0;
        int lastIndexUnsorted = arr.length-1;

        while (lastIndexUnsorted != 0) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }

            if (i == lastIndexUnsorted-1) {
                i = 0;
                lastIndexUnsorted--;
            } else {
                i++;
            }
        }
    }
}
