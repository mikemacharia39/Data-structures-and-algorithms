package javasolutionsforalgorithms.revision_v2.hackerrank.greedy;

import java.util.List;

/**
 * Alice is a kindergarten teacher. She wants to give some candies to the children in her class.
 * All the children sit in a line and each of them has a rating score according to his or her performance in the class.
 * Alice wants to give at least 1 candy to each child.
 * If two children sit next to each other, then the one with the higher rating must get more candies.
 * Alice wants to minimize the total number of candies she must buy.
 *
 * Example:
 * arr = [2, 6, 4, 5, 6, 2]
 *
 * Answer = [1, 2, 1, 2, 3, 1]. She must buy a minimum of 10 candies.
 */
public class Candies {

    /**
     * Explanation: The solution is to create two arrays left and right. The left array stores the number of candies
     * given to the left child if the left child has a higher rating than the right child. The right array stores the
     * number of candies given to the right child if the right child has a higher rating than the left child.
     * The answer is the maximum of the left and right arrays.
     *
     * Time complexity = O(N)
     * Space complexity = O(N) because of left and right arrays
     * @param n
     * @param arr
     * @return
     */
    public static long candies(int n, List<Integer> arr) {
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = arr.get(i) > arr.get(i - 1) ? left[i - 1] + 1 : 1;
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = arr.get(i) > arr.get(i + 1) ? right[i + 1] + 1 : 1;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }

}
