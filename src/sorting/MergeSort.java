package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] myArray = {7, 14, 3, 5, 13, 10, 11, 6, 9, 4, 1, 8, 12, 2, 15};
        mergeSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    public static void mergeSort(int[] arr) {
        if (arr.length == 1)
            return;

        int right = arr.length-1;
        int left = 0;

        int mid = (right+left)/2;
        int leftSize = mid-left+1;
        int rightSize = right-mid;

        int[] leftSide = new int[leftSize];
        int[] rightSide = new int[rightSize];

        for (int i = 0; i < leftSize; i++)
            leftSide[i] = arr[i];
        for (int i = 0; i < rightSize; i++)
            rightSide[i] = arr[i+(mid+1)];

        mergeSort(leftSide);
        mergeSort(rightSide);
        mergeArray(arr, leftSide, rightSide);
    }

    public static void mergeArray(int[] arr, int[] leftSide, int[] rightSide) {
        int iArr = 0;
        int iLeft = 0;
        int iRight = 0;

        int leftSize = leftSide.length;
        int rightSize = rightSide.length;

        while (iLeft<leftSize && iRight<rightSize) {
            if (leftSide[iLeft] < rightSide[iRight]) {
                arr[iArr] = leftSide[iLeft];
                iLeft++;
            } else {
                arr[iArr] = rightSide[iRight];
                iRight++;
            }
            iArr++;
        }

        while (iLeft < leftSize) {
            arr[iArr] = leftSide[iLeft];
            iArr++;
            iLeft++;
        }

        while (iRight < rightSize) {
            arr[iArr] = rightSide[iRight];
            iArr++;
            iRight++;
        }
    }
}
