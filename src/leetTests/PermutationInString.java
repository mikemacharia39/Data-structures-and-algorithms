package leetTests;

import java.util.Arrays;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words,
 * one of the first string's permutations is the substring of the second string.
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length() || s1.length() == 0 || s2.length() == 0) {
            return false;
        }

        int[] arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i)-'a']++;
        }

        for (int j = 0; j <= (s2.length() - s1.length()); j++) {
            String subS = s2.substring(j, s1.length()+j);

            int[] arr2 = new int[26];
            for (int i = 0; i < subS.length(); i++) {
                arr2[subS.charAt(i)-'a']++;
            }

            if (Arrays.equals(arr, arr2)) {
                return true;
            }
        }

        return false;
    }
}
