import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] myArray = {7, 14, 3, 5, 13, 10, 11, 6, 9, 4, 1, 8, 12, 2, 15};
        bubbleSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    public static void bubbleSort(int[] intArray) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i=0; i<intArray.length-1; i++) {
                int temp;
                if (intArray[i]>intArray[i+1]) {
                    temp = intArray[i];
                    intArray [i] = intArray[i+1];
                    intArray[i+1] = temp;
                    flag = true;
                }
            }
        }
    }
}
