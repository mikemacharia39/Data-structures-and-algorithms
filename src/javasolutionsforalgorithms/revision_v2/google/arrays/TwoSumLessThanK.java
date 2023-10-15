package javasolutionsforalgorithms.revision_v2.google.arrays;

import java.util.Arrays;

/**
 * Pair with largest sum which is less than K in the array
 * Given an array arr of size N and an integer K. The task is to find the pair of integers such that
 * their sum is maximum and but less than K
 *
 * Examples:
 * Input : arr = {30, 20, 50} , K = 70
 * Output : 30, 20
 * 30 + 20 = 50, which is the maximum possible sum which is less than K
 * Input : arr = {5, 20, 110, 100, 10}, K = 85
 * Output : 20, 10  = 30
 */
public class TwoSumLessThanK {

    /**
     * Sort the array and use 2 pointers to find the max sum less than k
     * Time complexity: O(NlogN) - because of the sorting
     * Auxiliary Space: O(1)
     * @param numbers array of numbers
     * @param k target
     * @return max sum of 2 numbers less than k
     */
    public int maxSum(int[] numbers, int k) {
        Arrays.sort(numbers);
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < k) {
                max = Math.max(max, sum);
                left++;
            } else {
                right--;
            }
        }

        return max;
    }


        /**
         * Brute force: 2 for loops to find all possible sums less than k
         * Time complexity: O(N^2)
         * Auxiliary Space: O(1)
         * @param numbers array of numbers
         * @param k target
         * @return max sum of 2 numbers less than k
         */
    public int maxSum_1(int[] numbers, int k) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (sum < k) {
                    max = Math.max(max, sum);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        TwoSumLessThanK twoSumLessThanK = new TwoSumLessThanK();
        int[] arr = {30, 20, 50};
        int k = 70;
        System.out.println(twoSumLessThanK.maxSum(arr, k)); // 50

        int[] arr2 = {4, 5, 20, 110, 100, 80, 10};
        int k2 = 85;
        System.out.println(twoSumLessThanK.maxSum(arr2, k2)); // 84
    }
}
