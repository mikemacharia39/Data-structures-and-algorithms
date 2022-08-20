package javasolutionsforalgorithms.leettests.arrays;

import java.util.Arrays;

/**
 * I am just confirming that I remember how to work with 2D arrays
 */
public class TwoDimensionalArray {

    public static void main(String[] args) {
        int[][] array = {{1,2}, {3,9}, {9,5}, {4,7}};

        int[][] sumArray = new int[4][1];

        // sum items in a 2D array and return 2D array with summations
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
            sumArray[i][0] = sum;
        }

        System.out.print("[");
        int count = 0;
        for (int[] arr : sumArray) {
            count++;
            System.out.print(Arrays.toString(arr));
            if (count < sumArray.length) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
