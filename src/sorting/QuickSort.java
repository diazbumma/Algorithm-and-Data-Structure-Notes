package sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] intArray = {7, 14, 3, 5, 13, 10, 11, 6, 9, 4, 1, 8, 12, 2, 15};
        quickSort(intArray, 0, intArray.length);
        System.out.println(Arrays.toString(intArray));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (end-start < 2)
            return;

        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex);
        quickSort(arr, pivotIndex+1, end);
    }

    public static int partition(int[]arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && arr[--j] >= pivot);
            if (i < j)
                arr[i] = arr[j];

            while (i < j && arr[++i] <= pivot);
            if (i < j)
                arr[j] = arr[i];
        }

        arr[j] = pivot;
        return j;
    }
}
