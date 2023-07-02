package javasolutionsforalgorithms.revision_v2.leetcode.leetcode.string;

/**
 * Given a string s, return the longest palindromic substring in s.
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        String longest = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String subString = s.substring(i, j);
                if (subString.length() > longest.length() &&
                        isPalindrome(subString)) {
                    longest = subString;
                }
            }
        }

        return longest;
    }

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
