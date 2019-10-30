import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] myArray = {7, 14, 3, 5, 13, 10, 11, 6, 9, 4, 1, 8, 12, 2, 15};
        mergeSort(myArray,  myArray.length);
        System.out.println(Arrays.toString(myArray));
    }

    //n denotes array size which will be sorted
    public static void mergeSort(int[] intArray, int n) {
        if (n < 2)
            return;
        int mid = n/2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[n-mid];
        for (int i = 0; i < mid; i++)
            leftArr[i] = intArray[i];
        for (int i = mid; i < n; i++)
            rightArr[i - mid] = intArray[i];
        mergeSort(leftArr, mid);
        mergeSort(rightArr, n-mid);
        merge(intArray, leftArr, rightArr, mid, n-mid);
    }

    public static void merge(int[] intArray, int[] leftArr, int[] rightArr, int left, int right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left && j < right) {
            if (leftArr[i] <= rightArr[j]) {
                intArray[k] = leftArr[i];
                i++;
            } else {
                intArray[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i<left) {
            intArray[k] = leftArr[i];
            i++;
            k++;
        }
        while (j<right) {
            intArray[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
