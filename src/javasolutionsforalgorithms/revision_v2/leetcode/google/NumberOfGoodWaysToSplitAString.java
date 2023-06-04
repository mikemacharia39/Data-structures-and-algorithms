package javasolutionsforalgorithms.revision_v2.leetcode.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumberOfGoodWaysToSplitAString {


    /**
     * Using a hashmap to keep track of the number of occurrences of each character
     * @param s string input
     * @return number of good splits
     */
    public int numSplits(String s) {
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
