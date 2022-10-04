package javasolutionsforalgorithms.leettests.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/array-left-rotation/problem">...</a>
 *
 * A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left.
 * Given an integer, d, rotate the array that many steps left and return the result.
 *
 * Example
 * d = 2
 * arr = [1,2,3,4,5]
 * After 2 rotations, arr' = [3,4,5,1,2]
 *
 * Function Description
 *
 * Complete the rotateLeft function in the editor below.
 *
 * rotateLeft has the following parameters:
 *
 * int d: the amount to rotate by
 * int arr[n]: the array to rotate
 */
public class LeftRotation {
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // shifts = 4
        // 1 2 3 4 5
        // 5 1 2 3 4
        int n = arr.size();
        Integer[] shifted = new Integer[n];
        for (int i = n-1; i >= 0; i--) {
            int newPos = (Math.abs(i+d))%n;
            shifted[i] = arr.get(newPos);
        }

        return Arrays.asList(shifted);
    }
}
