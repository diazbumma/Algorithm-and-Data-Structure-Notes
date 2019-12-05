package sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] myArray = {7, 14, 3, 5, 13, 10, 11, 6, 9, 4, 1, 8, 12, 2, 15};
        insertionSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    public static void insertionSort(int[] intArray) {
        for (int i=1; i<intArray.length; i++) {
            int key = i;
            int temp;
            while (intArray[key]<intArray[key-1]) {
                temp = intArray[key];
                intArray[key] = intArray[key-1];
                intArray[key-1] = temp;
                if (key!=1)
                    key--;
            }
        }
    }
}
