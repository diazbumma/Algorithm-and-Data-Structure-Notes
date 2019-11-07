import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] myArray = {7, 14, 3, 5, 13, 10, 11, 6, 9, 4, 1, 8, 12, 2, 15};
        mergeSort(myArray,  0, myArray.length-1);
        System.out.println(Arrays.toString(myArray));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (arr.length == 1)
            return;
        int mid = (right+left)/2;
        int leftSize = mid-left+1;
        int rightSize = right-mid;
        int[] leftSide = new int[leftSize];
        int[] rightSide = new int[rightSize];
        for (int i = 0; i < leftSize; i++)
            leftSide[i] = arr[i];
        for (int i = 0; i < rightSize; i++)
            rightSide[i] = arr[i+(mid+1)];
        mergeSort(leftSide, 0, leftSize-1);
        mergeSort(rightSide, 0, rightSize-1);
        mergeArray(arr, leftSide, rightSide, leftSize, rightSize);
    }

    public static void mergeArray(int[] arr, int[] leftside, int[] rightSide, int leftSize, int rightSize) {
        int iArr = 0;
        int iLeft = 0;
        int iRight = 0;
        while (iLeft<leftSize && iRight<rightSize) {
            if (leftside[iLeft] < rightSide[iRight]) {
                arr[iArr] = leftside[iLeft];
                iLeft++;
            } else {
                arr[iArr] = rightSide[iRight];
                iRight++;
            }
            iArr++;
        }
        while (iLeft < leftSize) {
            arr[iArr] = leftside[iLeft];
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
