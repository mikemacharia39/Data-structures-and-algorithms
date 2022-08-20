package javasolutionsforalgorithms.hackerrank.string;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Given two strings, determine if they share a common substring. A substring may be as small as one character.
 *
 * Example 1:
 * s1 = and
 * s2 = art
 *
 * These share the common substring a.
 *
 * Example 2:
 * s1 = be
 * s2 = cat
 *
 * These do not share a substring.
 *
 * Function Description
 *
 * Complete the function twoStrings in the editor below. twoStrings has the following parameter(s):
 *
 * string s1: a string
 * string s2: another string
 * Returns  -> string: either YES or NO
 */
public class CommonSubstringOfTwoStrings {

    /**
     * This is the weirdest solution. Since you are determining the common substring
     * between the two string then why not just check if the characters exist within
     * the alphabet sequence.
     * Time complexity O(n) because we run a loop
     * Space complexity O(n) because of the new memory (char[]) introduce
     */
    public static String twoStrings(String s1, String s2) {
        //hello
        //world
        //have unique substrings o and l

        String alphabetStr = "abcdefghijklmnopqrstuvwxyz";
        for (char c : alphabetStr.toCharArray()) {
            if (s1.indexOf(c) > -1 && s2.indexOf(c) > -1) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {

        String s1 = "hello", s2 = "world";
        Logger.getLogger("CommonSubstringOfTwoStrings")
                .log(Level.INFO, "Has a common substring: {0}",
                        CommonSubstringOfTwoStrings.twoStrings(s1, s2));
    }
}
