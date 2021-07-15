package leetTests;

import java.util.Arrays;

/**
 * Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 * Example 2:
 *
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 * Example 3:
 *
 * Input: word1 = "cabbba", word2 = "abbccc"
 * Output: true
 * Explanation: You can attain word2 from word1 in 3 operations.
 * Apply Operation 1: "cabbba" -> "caabbb"
 * Apply Operation 2: "caabbb" -> "baaccc"
 * Apply Operation 2: "baaccc" -> "abbccc"
 * Example 4:
 *
 * Input: word1 = "cabbba", word2 = "aabbss"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any amount of operations.
 */
public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
//        String s1 = "cabbba", s2 = "abbccc"; //true
//        String s1 = "cabbba", s2 = "aabbss"; //false
        String s1 = "uau", s2 = "ssx";       //false

        DetermineIfTwoStringsAreClose ifTwoStringsAreClose = new DetermineIfTwoStringsAreClose();
        System.out.println(ifTwoStringsAreClose.closeStrings(s1, s2));
    }
    public boolean closeStrings(String word1, String word2) {

        int[] charW1 = toArray(word1);
        int[] charW2 = toArray(word2);

        for (int j = 0; j < 26; j++) {
            // check if the indices contain the same count
            if (charW1[j] == charW2[j]) {
                continue;
            }

            // if condition 1 is not met ensure that at least they are not 0 on the same
            // index level, if 0, then word 2 can not be created with word 1
            if (charW1[j] == 0 || charW2[j] == 0) {
                return false;
            }
        }

        // if criteria above is not met, the this sorts both arrays and checks if
        // sorted then both counts at the indices should be the same otherwise
        // they shall fail
        Arrays.sort(charW1);
        Arrays.sort(charW2);
        for (int k = 0; k < 26; k++) {
            if (charW1[k] != charW2[k]) {
                return false;
            }
        }

        return true;
    }

    private int[] toArray(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        return arr;
    }
}
