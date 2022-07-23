package leettests.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/">...</a>
 * You are given an array of strings words (0-indexed).
 *
 * In one operation, pick two distinct indices i and j, where words[i] is a non-empty string,
 * and move any character from words[i] to any position in words[j].
 *
 * Return true if you can make every string in words equal using any number of operations, and false otherwise.
 *
 * Example 1:
 *
 * Input: words = ["abc","aabc","bc"]
 * Output: true
 * Explanation: Move the first 'a' in words[1] to the front of words[2],
 * to make words[1] = "abc" and words[2] = "abc".
 * All the strings are now equal to "abc", so return true.
 *
 * Example 2:
 *
 * Input: words = ["ab","a"]
 * Output: false
 * Explanation: It is impossible to make all the strings equal using the operation.
 */
public class RedistributeCharactersToMakeAllStringsEqual {

    /**
     * This solution organizes the characters in a map
     * The key represents the character and the value represents the frequency of the character in the
     * array
     *
     * In a scenario where all words are equal, this means cummulatively the frequency of each distinct character
     * should be divisible equal across all arrays
     * i.e. frequencyOfChar%words.length == 0 if equally distributed
     */
    public boolean makeEqual(String[] words) {

        if (words.length < 2) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                map.put(word.charAt(i), map.getOrDefault(word.charAt(i),0)+1);
            }
        }

        for (char key : map.keySet()) {
            if (map.get(key) % words.length != 0) {
                return false;
            }
        }

        return true;
    }
}
