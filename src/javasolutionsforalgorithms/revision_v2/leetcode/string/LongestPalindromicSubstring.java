package javasolutionsforalgorithms.revision_v2.leetcode.string;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">...</a>
 *
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

    /**
     * This is a brute force solution. We will generate all the substrings and check if they are palindrome.
     * Time complexity: O(n^3)
     */
    public String longestPalindrome1(String s) {
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

    /**
     * Time complexity O(n^2)
     * Explanation: The idea is to expand around the center of the palindrome. There are two types of palindromes:
     * - odd length palindrome: aba
     * - even length palindrome: abba
     * For each character in the string, we will expand around the center of the palindrome. The center of the palindrome
     * can be either the character itself or the character and the next character.
     * For example: aba, the center of the palindrome is b. For abba, the center of the palindrome is bb.
     * We will expand around the center of the palindrome and check if the left and right characters are equal.
     * If they are equal, we will expand further. If they are not equal, we will break out of the loop.
     * We will keep track of the longest palindrome and return it.
     * For In depth explanation visit: https://www.youtube.com/watch?v=UflHuQj6MVA
     * @param s string
     * @return longest palindrome
     */
    public String longestPalindrome(String s) {
        // more optimized solution
        int n = s.length();
        String longest = "";
        for (int i = 0; i < n; i++) {
            String odd = expandAroundCenter(s, i, i);
            String even = expandAroundCenter(s, i, i + 1);

            if (odd.length() > longest.length()) {
                longest = odd;
            }

            if (even.length() > longest.length()) {
                longest = even;
            }
        }

        return longest;
    }

    /**
     *
     * @param s
     * @param i
     * @param i1
     * @return
     */
    private String expandAroundCenter(String s, int i, int i1) {
        // i and i1 are the center of the palindrome
        int left = i;
        int right = i1;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
