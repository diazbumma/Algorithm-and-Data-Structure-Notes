import java.math.BigInteger;
import java.util.Arrays;

/*
 * Merge sort with very big integers
 */
public class BigIntegerMergeSort {

    public static void main(String[] args) {
        String[] bigIntArray = {"1",
                "2",
                "100",
                "12303479849857341718340192371",
                "3084193741082937",
                "3084193741082938",
                "111",
                "200"};
        String[] result = bigSorting(bigIntArray);
        System.out.println(Arrays.toString(result));
    }

    public static String[] bigSorting(String[] unsorted) {
        BigInteger[] bigIntegers = new BigInteger[unsorted.length];
        for (int i = 0; i < unsorted.length; i++)
            bigIntegers[i] = new BigInteger(unsorted[i]);
        mergeSort(bigIntegers, 0, bigIntegers.length-1);
        String[] result = new String[bigIntegers.length];
        for (int i = 0; i < bigIntegers.length; i++)
            result[i] = bigIntegers[i].toString();
        return result;
    }

    public static void mergeSort(BigInteger[] arr, int left, int right) {
        if (arr.length == 1)
            return;
        int mid = (right+left)/2;
        int leftSize = mid-left+1;
        int rightSize = right-mid;
        BigInteger[] leftSide = new BigInteger[leftSize];
        BigInteger[] rightSide = new BigInteger[rightSize];
        for (int i = 0; i < leftSize; i++)
            leftSide[i] = arr[i];
        for (int i = 0; i < rightSize; i++)
            rightSide[i] = arr[i+(mid+1)];
        mergeSort(leftSide, 0, leftSide.length-1);
        mergeSort(rightSide, 0, rightSide.length-1);
        mergeArray(arr, leftSide, rightSide, leftSize, rightSize);
    }

    public static void mergeArray(BigInteger[] arr, BigInteger[] leftside, BigInteger[] rightSide,
                                  int leftSize, int rightSize) {
        int iArr = 0;
        int iLeft = 0;
        int iRight = 0;
        while (iLeft<leftSize && iRight<rightSize) {
            if (leftside[iLeft].compareTo(rightSide[iRight]) < 0) {
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
