package javasolutionsforalgorithms.leettests.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-matching-subsequences/">...</a>
 *
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 *
 * Example 1:
 *
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 */
public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<String, Integer> wordOccurrence = new HashMap<>();
        for (String word : words) {
            wordOccurrence.put(word, wordOccurrence.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordOccurrence.entrySet()) {
            count += isSubsequence(s, entry.getKey()) ? entry.getValue() : 0;
        }

        return count;
    }

    private boolean isSubsequence(String s, String word) {
        if (word.length() > s.length()) return false;

        int index = -1;

        for (char c : word.toCharArray()) {
            index = s.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }

        return true;
    }
}
