package hired;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">...</a>
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * This solution gives you the longest non repeating substring
     * **** But does not show the actual longest substring ******
     */
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        int max = 0;
        int i = 0;
        int j = 0;

        HashSet<Character> set = new HashSet<>();

        while (j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                max = Math.max(max, set.size());
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstringSln1(String s) {

        int len = s.length();
        int max = 0;

        // abca
        // a[61] = true
        // b[62] = true
        // c[63] = true
        // a[61] -> visited -> then break

        for (int i = 0; i < len; i++) {
            boolean[] isVisited = new boolean[256];
            for (int j = i; j < len; j++) {
                if (isVisited[s.charAt(j)]) {
                    break;
                } else {
                    max = Math.max(max, j-i+1);
                    isVisited[s.charAt(j)] = true;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters withoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();

        String[] strings = {"abcabcbb", "bbbb", "pwwkew"};

        for (String str : strings) {
            int x = withoutRepeatingCharacters.lengthOfLongestSubstring(str);
            Object[] objects = {str, x};
            Logger.getLogger("LongestNonRepeatingSubstring").log(Level.INFO, "String: {0} Length: {1}", objects);
        }
    }
}
