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
     * Use array
     * arr[word.charAt(i) - 'a']++;
     * Assuming word.charAt(i) = c
     * 'c' - 'a' = 3 - 1 = 2
     *
     * This means arr[2]
     * At position 2 of the array, the value will be +1
     * Every time the same character is encountered, the value is incremented
     *
     * @param words arr
     * @return true|false
     */
    public boolean makeEqual(String[] words) {
        int[] freq = new int[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                freq[word.charAt(i) - 'a']++;
            }
        }

        for (int n : freq) {
            if (n % words.length != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * This solution organizes the characters in a map
     * The key represents the character and the value represents the frequency of the character in the
     * array
     *
     * In a scenario where all words are equal, this means cummulatively the frequency of each distinct character
     * should be divisible equal across all arrays
     * i.e. frequencyOfChar%words.length == 0 if equally distributed
     */
    public boolean makeEqual1(String[] words) {

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
