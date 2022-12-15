package javasolutionsforalgorithms.leettests.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/print-words-vertically/">...</a>
 *
 * Given a string s. Return all the words vertically in the same order in which they appear in s.
 * Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
 * Each word would be put on only one column and that in one column there will be only one word.
 *
 * Example 1:
 *
 * Input: s = "HOW ARE YOU"
 * Output: ["HAY","ORO","WEU"]
 * Explanation: Each word is printed vertically.
 *  "HAY"
 *  "ORO"
 *  "WEU"
 *
 * Example 2:
 *
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


}
