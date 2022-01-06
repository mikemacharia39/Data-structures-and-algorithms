package leettests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * You are given a string s, a split is called good if you can split s into 2 non-empty strings p and q
 * where its concatenation is equal to s and the number of distinct letters in p and q are the same.
 *
 * Return the number of good splits you can make in s.
 *
 *
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
 *
 * Example 2:
 *
 * Input: s = "abcd"
 * Output: 1
 * Explanation: Split the string as follows ("ab", "cd").
 */
public class NumberOfGoodWaysToSplitString {

    public static void main(String[] args) {

        NumberOfGoodWaysToSplitString splitString = new NumberOfGoodWaysToSplitString();
        String s = "acbadbaada";
        System.out.println(splitString.numSplits(s));
    }

    /**
     * BEST SOLN
     * @param s
     * @return
     */
    public int numSplits(String s) {

        // Save distict values and have a map of the values
        Set<Character> distictSet = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            distictSet.add(s.charAt(i));
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        // Manage the left set
        Set<Character> distictLeft = new HashSet<>();

        // manage good splits
        int split = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0)-1);
            }
            if (map.get(c) == 0) {
                map.remove(c);
                distictSet.remove(c);
            }
            distictLeft.add(c);

            if (distictLeft.size() == distictSet.size()) {
                split++;
            }
        }

        return split;
    }

    public int numSplitsSln0(String s) {

        if (s.length() <= 1) {return 0;}

        int strLength = s.length();

        int goodSplit = 0;
        for (int i = 1; i < strLength; i++) {
            String sleft = s.substring(0, i);
            String sright = s.substring(i);

            Set<Character> setL = toSet(sleft);
            Set<Character> setR = toSet(sright);
            if (setL.size() == setR.size()) {
                goodSplit++;
            }
        }

        return goodSplit;
    }

    private Set<Character> toSet(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set;
    }
}
