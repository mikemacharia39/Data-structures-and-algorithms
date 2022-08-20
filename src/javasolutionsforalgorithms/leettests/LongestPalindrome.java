package javasolutionsforalgorithms.leettests;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Example 3:
 *
 * Input: s = "bb"
 * Output: 2
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();

        String s = "abccccdd";
        System.out.println(longestPalindrome.longestPalindrome(s));
    }

    public int longestPalindrome(String s) {

        // essentially you would need even no. of characters to be on
        // both sides and at most one one character
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }

        int oddNumberCount = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] % 2 != 0) {
                oddNumberCount++;
            }
        }

        int longestPalindrome = s.length() - oddNumberCount;
        if (oddNumberCount > 0) {
            longestPalindrome = longestPalindrome + 1;
        }

        return longestPalindrome;
    }

    public int longestPalindromeSLN1(String s) {

        // essentially you would need even no. of characters to be on
        // both sides and at most one one character

        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        int longestPalindrome = s.length() - set.size();
        if (set.size() != 0) {
            longestPalindrome = longestPalindrome + 1;
        }

        return longestPalindrome;
    }
}
