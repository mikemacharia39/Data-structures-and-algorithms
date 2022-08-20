package javasolutionsforalgorithms.leettests.arrays;

import java.util.Arrays;

/**
 * Given a fixed-length integer array arr, duplicate each occurrence of zero,
 * shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place and do not return anything.
 *
 * Example 1:
 *
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 *
 * Example 2:
 *
 * Input: arr = [1,2,3]
 * Output: [1,2,3]
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 */
public class DuplicateZeros {

    /**
     * Where there is zero make the next value a zero
     */
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                shift(arr, i+1);
                if (i != arr.length - 1) {  // ensure element is not last of the array e.g. [1,2,0]
                    arr[i+1] = 0;
                    i++;                    // shift pointer to the right, after assigning position to new element
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * Create space while ensuring we don't encounter an array out of bounds exception
     * This shift elements at position x once step behind i.e. x-1
     */
    private void shift(int[] arr, int index) {
        for (int i = arr.length - 1; i >= index; i--) {
            arr[i] = arr[i-1];
        }
    }

    public static void main(String[] args) {

    }
}
