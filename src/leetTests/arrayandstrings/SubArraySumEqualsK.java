package leetTests.arrayandstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of integers nums and an integer k, return the total number of continuous
 * sub arrays whose sum equals to k.
 *
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2 -> i.e. 1,1 and 1 and 1
 *
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2 -> i.e. 1,2 and 3
 */
public class SubArraySumEqualsK {

    public static void main(String[] args) {
        SubArraySumEqualsK sumEqualsK = new SubArraySumEqualsK();

        int[] arr = {1,2,3};
        int k = 3;

        System.out.println("Ans: " + sumEqualsK.solution(arr, k));
    }

    /**
     * The solution to find the total number of contiguous sub arrays involves having 2 loops
     * the first is a pointer to where we are and the second to calculate sum of elements
     * @param array array
     * @param sum sum of elements
     * @return count
     */
    private int solution(int[] array, int sum) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int total = 0;
            for (int j = i; j < array.length; j++) {
                total += array[j];
                if (total == sum) {
                    count++;
                }
            }
        }

        return count;
    }
}
