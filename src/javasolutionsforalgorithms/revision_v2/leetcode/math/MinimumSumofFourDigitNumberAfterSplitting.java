package javasolutionsforalgorithms.revision_v2.leetcode.math;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/">...</a>
 *
 * You are given a positive integer num consisting of exactly four digits. Split num into two new integers new1 and new2
 * by using the digits found in num. Leading zeros are allowed in new1 and new2, and all the digits found in num must be used.
 *
 * For example, given num = 2932, you have the following digits: two 2's, one 9 and one 3. Some of the possible
 * pairs [new1, new2] are [22, 93], [23, 92], [223, 9] and [2, 329].
 * Return the minimum possible sum of new1 and new2.
 */
public class MinimumSumofFourDigitNumberAfterSplitting {
    // these is greedy approach
    // the idea here is to minimize the value
    public int minimumSum(int num) {
        int[] digits = new int[4];

        int i = 0;
        while (num > 0) {
            int modulus = num % 10;
            num = num / 10;
            digits[i++] = modulus;
        }

        Arrays.sort(digits);

        int sum = (digits[0] * 10 + digits[2]) + (digits[1] * 10 + digits[3]);

        return sum;
    }

    /**
     * Same as above but using string
     * Explanation: this uses greedy approach to minimize the value of the number by putting the smallest digits
     * in the front and the largest digits in the back of the number
     * Time complexity: O(nlogn) for sorting
     * @param num
     * @return
     */
    public int minimumSum1(int num) {
        char[] characters = Integer.toString(num).toCharArray();

        Arrays.sort(characters);

        int sum = Integer.parseInt("" + characters[0] + characters[2]) +
                Integer.parseInt("" + characters[1] + characters[3]);

        return sum;
    }
}
