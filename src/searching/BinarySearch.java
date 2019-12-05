package searching;

public class BinarySearch {

    public static void main(String[] args) {
        int[] myArray = {2, 5, 8, 9, 11, 15, 17, 21, 30};
        System.out.println(binarySearch(myArray, 21));
    }

    //returns an index if value is found in an array, returns -1 if value is not found
    public static int binarySearch(int[] intArray, int value) {
        int start = 0;
        int end = intArray.length-1;
        int mid = intArray.length/2;
        while (intArray[mid] != value) {
            mid = (start+end)/2;
            if (intArray[mid] > value)
                end = mid-1;
            else if (intArray[mid] < value)
                start = mid+1;
            if (start>end && mid!=value)
                return -1;
        }
        return mid;
    }
}
