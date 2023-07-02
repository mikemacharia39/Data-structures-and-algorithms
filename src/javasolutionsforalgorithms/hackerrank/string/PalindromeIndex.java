package javasolutionsforalgorithms.hackerrank.string;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Given a string of lowercase letters in the range ascii[a-z],
 * determine the index of a character that can be removed to make the string a palindrome.
 * There may be more than one solution, but any will do.
 * If the word is already a palindrome or there is no solution, return -1.
 * Otherwise, return the index of a character to remove.
 *
 * Example 1:
 * String bcbc
 *
 * Either remove 'b' at index 0 or 'c' at index 3.
 *
 *
 * We have done sth similar or javasolutionsforalgorithms.leettests.ValidPalindromeByRemoveOneChar
 */

public class PalindromeIndex {

    public int thePalindromeIndex(String s) {

        if (isPalindrome(s)) {
            return -1;
        }

        int right = s.length() - 1;
        for (int left = 0; left < s.length()/2; left++) {
            String removeFromLeft =  s.substring(0, left) + s.substring(left + 1);
            String removeFromRight =  s.substring(0, right) + s.substring(right + 1);

            if (isPalindrome(removeFromLeft)) {
                return left;
            }

            if (isPalindrome(removeFromRight)) {
                return right;
            }

            right--;
        }
        return -1;
    }

    private boolean isPalindrome1(String s) {
        int right = s.length() - 1;
        for (int left = 0; left < s.length()/2; left++) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            right--;
        }
        return true;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param s string
     * @return true if string is palindrome
     */
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeIndex palindromeIndex = new PalindromeIndex();

        String[] s = {"baaa", "aaaab", "aaa"};

        for (String str : s) {
            Object[] objects = {str, palindromeIndex.thePalindromeIndex(str)};
            Logger.getLogger(PalindromeIndex.class.getName()).log(Level.INFO,
                    "To make string {0} a palindrome remove index {1}", objects);
        }


    }
}
