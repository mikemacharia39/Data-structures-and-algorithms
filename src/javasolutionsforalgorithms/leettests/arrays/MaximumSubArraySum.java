package javasolutionsforalgorithms.leettests.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * We define the following:
 * <p>
 * A subarray of array  of length  is a contiguous segment from a[i] through a[j] where a <= i <= j < n.
 * The sum of an array is the sum of its elements.
 * Given an n element array of integers, a, and an integer, m, determine the maximum value of the sum of any of its subarrays modulo .
 * <p>
 * Example
 * a = [1,2,3]
 * m = 2
 * The following table lists all subarrays and their moduli:
 * <p>
 * sum	%2
 * [1]		1	1
 * [2]		2	0
 * [3]		3	1
 * [1,2]    3	1
 * [2,3]	5	1
 * [1,2,3]	6	0
 * <p>
 * The maximum modulus is 1.
 * <p>
 * Function Description
 * <p>
 * Complete the maximumSum function in the editor below.
 * <p>
 * maximumSum has the following parameter(s):
 * <p>
 * long a[n]: the array to analyze
 * long m: the modulo divisor
 * Returns
 * - long: the maximum (subarray sum modulo m)
 */
public class MaximumSubArraySum {

    public static long maximumSum(List<Long> a, long m) {
        long max = 0, curr = 0;
        TreeSet<Long> tree = new TreeSet<>();

        for (int i = 0; i < a.size(); i++) {
            curr = (curr + a.get(i) % m) % m;
            max = Math.max(curr, max);
            long higher = tree.higher(curr) != null ? tree.higher(curr) : 0L;

            if (higher != 0L) {
                max = Math.max(max, (curr - higher + m) % m);
            }

            tree.add(curr);
        }

        return max;
    }

    public static long maximumSum1(List<Long> a, long m) {
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
        return sum % m;
    }

    public static void main(String[] args) {
        List<Long> list = Arrays.asList(3L, 3L, 9L, 9L, 5L);
        long m = 19;

        List<Long> list1 = Arrays.asList(1L, 2L, 3L);
        long m1 = 2;

        System.out.println(MaximumSubArraySum.maximumSum(list, m));
    }
}
