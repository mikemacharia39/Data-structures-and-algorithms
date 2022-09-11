package javasolutionsforalgorithms.leettests.arrays;

import java.util.List;

/**
 * We define the following:
 *
 * A subarray of array  of length  is a contiguous segment from a[i] through a[j] where a <= i <= j < n.
 * The sum of an array is the sum of its elements.
 * Given an n element array of integers, a, and an integer, m, determine the maximum value of the sum of any of its subarrays modulo .
 *
 * Example
 * a = [1,2,3]
 * m = 2
 * The following table lists all subarrays and their moduli:
 *
 * 		    sum	%2
 * [1]		1	1
 * [2]		2	0
 * [3]		3	1
 * [1,2]    3	1
 * [2,3]	5	1
 * [1,2,3]	6	0
 *
 * The maximum modulus is 1.
 *
 * Function Description
 *
 * Complete the maximumSum function in the editor below.
 *
 * maximumSum has the following parameter(s):
 *
 * long a[n]: the array to analyze
 * long m: the modulo divisor
 * Returns
 * - long: the maximum (subarray sum modulo m)
 */
public class MaximumSubArraySum {


    public static long maximumSum(List<Long> a, long m) {
        long max = Long.MIN_VALUE;

        int size = a.size();
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = i; j < size; j++) {
                sum += a.get(j);
                max = Math.max(max, modulus(sum, m));
            }
        }

        System.out.println("Max: " + max + " | vals: " + a);
        return max;
    }

    private static long modulus(long sum, long m) {
        return sum%m;
    }

    public static void main(String[] args) {


    }
}
