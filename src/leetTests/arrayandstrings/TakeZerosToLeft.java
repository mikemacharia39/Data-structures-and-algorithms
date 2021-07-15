package leetTests.arrayandstrings;

import java.util.Arrays;

/**
 * Given an array [1,0,0,0,2,0,4,3] you need to take all 0 s to the left and
 * maintain the order of non zeros. I.e [0,0,0,0,1,2,4,3]
 * dont use extra space. Do it in one loop. Lets go....
 */
public class TakeZerosToLeft {

    public static void main(String[] args) {
        TakeZerosToLeft zerosToLeft = new TakeZerosToLeft();

        int[] arr = {1,0,0,0,2,0,4,3};

        int val = 0;

        System.out.println("Cur: " + Arrays.toString(arr));

        int[] ans = zerosToLeft.orderArray(arr, val);

        System.out.println("New: " + Arrays.toString(ans));
    }

    /**
     * Algorithm :
     * The array is given. We will scan the elements from end to first.
     * For example , for the array {1,0,2,0,3,0},we will scan one by one element as 0,3,0,2,0 and 1.
     * Create one variable to store the current index. At first, its value is the last index of the array.
     * Check for each element of the array while scanning,
     * if it is not zero, add the value to the current index of the array.
     * After all values are completed, fill the remaining position of the array with 0.
     * Finally, print out the array.
     *
     * @param unordered arr
     * @param val value to put to left
     * @return ordered arr
     */
    private int[] orderArray(int[] unordered, int val) {
        int size = unordered.length - 1;

        for (int i = unordered.length - 1; i >= 0; i--) {
            if (unordered[i] != val) {
                unordered[size] = unordered[i];
                size--;
            }
        }

        while (size >= 0) {
            unordered[size] = val;
            size--;
        }

        return unordered;
    }
}
