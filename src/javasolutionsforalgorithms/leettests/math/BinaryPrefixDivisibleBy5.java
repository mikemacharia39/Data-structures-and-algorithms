package javasolutionsforalgorithms.leettests.math;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-prefix-divisible-by-5/">...</a>
 *
 * You are given a binary array nums (0-indexed).
 *
 * We define xi as the number whose binary representation is the subarray nums[0..i]
 * (from most-significant-bit to least-significant-bit).
 *
 * For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.
 * Return an array of booleans answer where answer[i] is true if xi is divisible by 5.
 *
 * Example 1:
 *
 * Input: nums = [0,1,1]
 * Output: [true,false,false]
 * Explanation: The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
 * Only the first number is divisible by 5, so answer[0] is true.
 *
 * Example 2:
 *
 * Input: nums = [1,1,1]
 * Output: [false,false,false]
 */
public class BinaryPrefixDivisibleBy5 {

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> booleans = new ArrayList<>();
        long sum = 0L;
        for (int num : nums) {
            sum = (sum * 2) + num;
            boolean b = sum % 5 == 0;
            booleans.add(b);

            //This is to prevent it from overflow, i.e. it will become a very big value to manage
            sum = sum%5;
        }
        return booleans;
    }

    private static long binaryStringToNumberConversion(String binary) {
        long num = 0L;
        for (int i = 0; i < binary.length(); i++) {
            num = (num * 2) + binary.charAt(i) - '0';
        }
        return num;
    }

    private static String numberToBinaryConversion(int number) {
        if (number <= 1) {
            return Integer.toString(number);
        }
        return numberToBinaryConversion(number/2) + numberToBinaryConversion(number % 2);
    }

    public static void main(String[] args) {
        String binaryString = numberToBinaryConversion(520);

        System.out.println("Binary Conversion: " + binaryString);

        System.out.println("Number Conversion: " + binaryStringToNumberConversion(binaryString));

        int[] nums = {1,1,1};
        System.out.println("Ans: " + prefixesDivBy5(nums));
    }
}
