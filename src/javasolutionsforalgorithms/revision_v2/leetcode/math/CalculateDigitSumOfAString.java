package javasolutionsforalgorithms.revision_v2.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/calculate-digit-sum-of-a-string/">...</a>
 *
 * You are given a string s consisting of digits and an integer k.
 *
 * A round can be completed if the length of s is greater than k. In one round, do the following:
 *
 * Divide s into consecutive groups of size k such that the first k characters are in the first group,
 * the next k characters are in the second group, and so on. Note that the size of the last group can be smaller than k.
 * Replace each group of s with a string representing the sum of all its digits. For example,
 * "346" is replaced with "13" because 3 + 4 + 6 = 13.
 * Merge consecutive groups together to form a new string. If the length of the string is greater than k, repeat from step 1.
 *
 * Example 1:
 *
 * Input: s = "11111222223", k = 3
 * Output: "135"
 * Explanation:
 * - For the first round, we divide s into groups of size 3: "111", "112", "222", and "23".
 *   Then we calculate the digit sum of each group: 1 + 1 + 1 = 3, 1 + 1 + 2 = 4, 2 + 2 + 2 = 6, and 2 + 3 = 5.
 *   So, s becomes "3" + "4" + "6" + "5" = "3465" after the first round.
 * - For the second round, we divide s into "346" and "5".
 *   Then we calculate the digit sum of each group: 3 + 4 + 6 = 13, 5 = 5.
 *   So, s becomes "13" + "5" = "135" after second round.
 * Now, s.length <= k, so we return "135" as the answer.
 */
public class CalculateDigitSumOfAString {

    /**
     * Time complexity: O(n)
     * @param s
     * @param k
     * @return
     */
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        while(sb.length() > k) {
            StringBuilder newString = new StringBuilder();
            int i = 0; // iterates over the entire string

            while (i < sb.length()) {
                int sum = 0;
                int count = 0; // iterates over the k characters

                while (i < sb.length() && count < k) {
                    sum += sb.charAt(i) - '0';
                    i++;
                    count++;
                }
                newString.append(sum);
            }
            sb = newString; // update the string
        }

        return sb.toString();
    }

    /**
     * This is pretty brute force
     * Time complexity: O(n^2)
     */
    public String digitSum1(String s, int k) {
        if (s.length() <= k) {
            return s;
        }

        String ans = "";
        List<String> divided = new ArrayList<>();
        divided.addAll(divider(s, k));
        int finalSize = checkDividedSize(divided);
        while (finalSize > k) {
            s = merge(divided);
            divided.clear();

            divided.addAll(divider(s, k));

            finalSize = checkDividedSize(divided);
        }

        return merge(divided);
    }

    /**
     * Checks if the size of the divided strings inside the list
     */
    private int checkDividedSize(List<String> list) {
        int size = 0;
        for (String s : list) {
            size += s.length();
        }
        return size;
    }

    /**
     * merge the subdivided list to a string
     */
    private String merge(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * Divides the string to a list
     * Time complexity: O(n)
     */
    private List<String> divider(String s, int k) {
        List<String> divided = new ArrayList<>();
        int i = 0;
        while (i < s.length() - k) {
            String substring = s.substring(i, i+k);
            divided.add(addNums(substring));

            i = i+k;
        }

        if (i < s.length()) {
            divided.add(addNums(s.substring(i)));
        }
        return divided;
    }

    /**
     * Adds the numbers in the each index of the list
     * Time complexity: O(n)
     */
    private String addNums(String subNums) {
        char[] charNums = subNums.toCharArray();
        int sum = 0;
        for (char c : charNums) {
            sum += c - '0'; // Character.getNumericValue(c);
        }
        return Integer.toString(sum);
    }
}
