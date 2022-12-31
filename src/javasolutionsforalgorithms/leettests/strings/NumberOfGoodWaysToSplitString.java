package javasolutionsforalgorithms.leettests.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/number-of-good-ways-to-split-a-string/submissions/">...</a>
 *
 * You are given a string s.
 *
 * A split is called good if you can split s into two non-empty strings sleft and sright
 * where their concatenation is equal to s (i.e., sleft + sright = s) and the number of distinct letters
 * in sleft and sright is the same.
 * Return the number of good splits you can make in s.
 *
 */
public class NumberOfGoodWaysToSplitString {

    /**
     * Better solution
     * @param s string
     * @return count
     */
    public int numSplits(String s) {
        int goodSplits = 0;
        HashMap<Character, Integer> leftMap = new HashMap<>();
        HashMap<Character, Integer> rightMap = new HashMap<>();

        // this will add disticts keys and their repetitions to the map
        for (int i = 0; i < s.length(); i++) {
            leftMap.put(s.charAt(i), leftMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        // add disticts keys and their repetitions to the map
        for (int i = 0; i < s.length(); i++) {
            rightMap.put(s.charAt(i), rightMap.getOrDefault(s.charAt(i), 0) + 1);

            // remove elements at the front of the map
            leftMap.put(s.charAt(i), leftMap.getOrDefault(s.charAt(i), 0) - 1);

            // consider when all of key freq are removed
            if (leftMap.get(s.charAt(i)) <= 0) {
                leftMap.remove(s.charAt(i));
            }

            // check if the remaining size of keys in leftMap = add keys in right map
            goodSplits += rightMap.size() == leftMap.size() ? 1 : 0;
        }

        return goodSplits;
    }

    /**
     * Timed-out
     * This is not a good solution. It times out in case when the string becomes very long, but it works ;)
     */
    public int numSplits2(String s) {
        int splits = 0;

        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0,i);
            String right = s.substring(i);
            if (getDistinctCount(left) == getDistinctCount(right)) {
                splits++;
            }
        }

        return splits;
    }


    private int getDistinctCount(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        return set.size();
    }
}
