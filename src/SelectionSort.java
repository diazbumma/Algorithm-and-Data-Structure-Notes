import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] myArray = {7, 14, 3, 5, 13, 10, 11, 6, 9, 4, 1, 8, 12, 2, 15};
        selectionSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    public static void selectionSort(int[] intArray) {
        for (int i=0; i<intArray.length-1; i++) {
            int jmin = i+1;
            for(int j=i+1; j<intArray.length; j++) {
                if (intArray[j]<intArray[jmin])
                    jmin = j;
            }
            if (intArray[jmin]<intArray[i]) {
                int temp = intArray[i];
                intArray[i] = intArray[jmin];
                intArray[jmin] = temp;
            }
        }
    }
}
