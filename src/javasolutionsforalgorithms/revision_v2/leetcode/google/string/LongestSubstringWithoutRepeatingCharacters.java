package javasolutionsforalgorithms.revision_v2.leetcode.google.string;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">...</a>
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * This solution uses a boolean array to keep track of visited characters. The fast slow pointer iterates over the string
     * while comparing the current character with the visited array. If the character is visited, then we break the inner loop
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_1(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            boolean[] isVisited = new boolean[256];
            for (int j = i; j < n; j++) {
                if (isVisited[s.charAt(j)]) {
                    break;
                } else {
                    max = Math.max(max, j - i + 1);
                    isVisited[s.charAt(j)] = true;
                }
            }
        }

        return max;
    }

    /**
     * This solution uses a HashSet to keep track of visited characters. The fast slow pointer iterates over the string
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < n) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                max = Math.max(max, set.size());
                i++;
            } else {
                set.remove(s.charAt(j));
                j++;
            }
        }

        return max;
    }
}
