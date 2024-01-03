package javasolutionsforalgorithms.revision_v2.leetcode.math;

import java.util.Arrays;

/**
 * Given an integer array queries and a positive integer intLength, return an array answer where answer[i] is either
 * the queries[i]th smallest positive palindrome of length intLength or -1 if no such palindrome exists.
 * <p>
 * A palindrome is a number that reads the same backwards and forwards. Palindromes cannot have leading zeros.
 * <p>
 * Example 1:
 * <p>
 * Input: queries = [1,2,3,4,5,90], intLength = 3
 * Output: [101,111,121,131,141,999]
 * Explanation:
 * The first few palindromes of length 3 are:
 * 101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 202, ...
 * The 90th palindrome of length 3 is 999.
 */
public class FindPalindromeWithFixedLength {

    /**
     * The logic is to find the start and end of the palindrome and then add the queries[i]th number to start and then
     * convert it to string. This is the left part of the palindrome. The minus 1 is because we are starting from 0
     * Time complexity = O(queries.length) = O(N)
     * @param queries
     * @param intLength
     * @return
     */
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] ans = new long[queries.length];

        int halfLength = (intLength + 1) / 2; //why n+1 because of odd length numbers

        long start = (long) Math.pow(10, halfLength - 1); // this is the start of the palindrome of length intLength
        long end = (long) Math.pow(10, halfLength) - 1;   // this is the end of the palindrome of length intLength

        long total = end - start + 1; // this is the total number of palindromes of length intLength
        System.out.println("start = " + start + " end = " + end +  " total = " + total);
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] <= total) {

                String left = Long.toString(start + queries[i] - 1); // this line adds the queries[i]th number to start and then converts it to string. This is the left part of the palindrome. The minus 1 is because we are starting from 0
                System.out.println("left = " + left);
                StringBuilder temp = new StringBuilder(left);
                String right = temp.reverse().toString();

                //this to handling for odd strings example for 4 -> 1001 but for 3 also it is 1001
                //but we don't want 1001 for 3 int length instead we want 101 so we have to remove 0 from right string which this formula likely to do
                ans[i] = Long.parseLong(left + right.substring(intLength % 2));
            } else
                ans[i] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindPalindromeWithFixedLength obj = new FindPalindromeWithFixedLength();
        long[] ans = obj.kthPalindrome(new int[]{1, 2, 3, 4, 5, 90}, 3);
        System.out.println(Arrays.toString(ans));
    }
}
