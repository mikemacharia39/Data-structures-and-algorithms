package javasolutionsforalgorithms.leettests.strings;

import java.util.HashSet;
import java.util.Set;

/**
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
