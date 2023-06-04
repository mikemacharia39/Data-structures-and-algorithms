package javasolutionsforalgorithms.revision_v2.leetcode.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/number-of-good-ways-to-split-a-string/">...</a>
 * You are given a string s.
 * A split is called good if you can split s into two non-empty strings sleft and sright where their
 * concatenation is equal to s (i.e., sleft + sright = s) and the number of distinct letters in sleft and sright is the same.
 * Return the number of good splits you can make in s
 *
 * Example 1:
 *
 * Input: s = "aacaba"
 * Output: 2
 * Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
 * ("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
 */
public class NumberOfGoodWaysToSplitAString {

    /**
     * Using 2 arrays to keep track of the number of occurrences of each character
     * @param s string input
     * @return number of good splits
     */
    public int numSplits(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];

        // store the characters and their frequencies in their corresponding position
        for (int i = 0; i < n; i++) {
            right[s.charAt(i)]++; // increment the frequency of the character
        }

        int goodSplitCount = 0;
        for(int i = 0; i < n; i++) {
            right[s.charAt(i) - 'a']--;
            left[s.charAt(i) - 'a']++;

            if (getArraySize(right) == getArraySize(left)) {
                goodSplitCount++;
            }
        }
        return goodSplitCount;
    }

    private int getArraySize(int[] arr) {
        int count = 0;
        for (int freq : arr) {
            if (freq != 0) {
                count++;
            }
        }
        return count;
    }


    /**
     * Using a hashmap to keep track of the number of occurrences of each character
     * @param s string input
     * @return number of good splits
     */
    public int numSplits_1(String s) {
        int n = s.length();

        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();

        for (int i = 0; i < n; i++) {
            right.put(s.charAt(i), right.getOrDefault(s.charAt(i), 0) +1);
        }

        int goodSplitCount = 0;

        for (int i = 0; i < n; i++) {
            left.put(s.charAt(i), left.getOrDefault(s.charAt(i), 0) +1);
            right.put(s.charAt(i), right.get(s.charAt(i)) - 1);

            if (right.get(s.charAt(i)) == 0) {
                right.remove(s.charAt(i));
            }

            if (right.size() == left.size()) {
                goodSplitCount++;
            }
        }

        return goodSplitCount;
    }

    /**
     * Naive approach - (Bad- because it run through all characters even
     * duplicated ones) Time limit exceeded
     * ---------------
     * Uses substring to split the string into 2 strings i.e. left and right
     * The progressively add characters to left while reducing on right and checking
     * if they are good splits
     */
    public int numSplits_2(String s) {
        String left = "";
        String right = "";
        int n = s.length();
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            left = s.substring(0, i);
            right = s.substring(i, n);

            if (uniqueStrLen(left) == uniqueStrLen(right)) {
                count++;
            }
        }

        return count;
    }

    private int uniqueStrLen(String sub) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < sub.length(); i++) {
            set.add(sub.charAt(i));
        }

        return set.size();
    }
}
