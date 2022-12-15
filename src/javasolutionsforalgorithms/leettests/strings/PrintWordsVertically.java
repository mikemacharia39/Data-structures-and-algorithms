package javasolutionsforalgorithms.leettests.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/print-words-vertically/">...</a>
 * <p>
 * Given a string s. Return all the words vertically in the same order in which they appear in s.
 * Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
 * Each word would be put on only one column and that in one column there will be only one word.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "HOW ARE YOU"
 * Output: ["HAY","ORO","WEU"]
 * Explanation: Each word is printed vertically.
 * "HAY"
 * "ORO"
 * "WEU"
 * <p>
 * Example 2:
 * <p>
 * Input: s = "TO BE OR NOT TO BE"
 * Output: ["TBONTB","OEROOE","   T"]
 * Explanation: Trailing spaces is not allowed.
 * "TBONTB"
 * "OEROOE"
 * "   T"
 */
public class PrintWordsVertically {

    public List<String> printVertically(String s) {
        String[] splitString = s.split(" ");
        int count = maxWordInString(splitString);
        List<String> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            list.add(getWords(splitString, i).stripTrailing());
        }

        return list;
    }

    private String getWords(String[] splitString, int index) {
        StringBuilder sb = new StringBuilder();
        for (String s : splitString) {
            if (index < s.length()) {
                sb.append(s.charAt(index));
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private int maxWordInString(String[] splitString) {
        int max = Integer.MIN_VALUE;
        for (String aStr : splitString) {
            max = Math.max(max, aStr.length());
        }

        return max;
    }

}
