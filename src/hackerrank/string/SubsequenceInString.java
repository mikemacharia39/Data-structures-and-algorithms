package hackerrank.string;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * We say that a string contains the word hackerrank if a subsequence of its characters spell the word hackerrank.
 * Remember that a subsequence maintains the order of characters selected from a sequence.\
 *
 * Example1
 * hhaackkerrannckk
 * This contains a subsequence of all of the characters in the proper order. Answer YES
 *
 * Example 2
 * hackeerank
 * This is missing the second 'r'. Answer NO.
 *
 * hccakeerrank
 * There is no 'c' after the first occurrence of an 'a', so answer NO.
 *
 */
public class SubsequenceInString {

    /**
     * Time complexity is 0 (n)
     * Space complexity is 0 (1)
     *
     * 1. check if strings are of similar length
     * 2. create 2 pointers, 1 to maintain the position of character in hackerrank 2 to maintain position
     *    of character in the other string
     *
     * @param s other string
     * @return YES | NO
     */
    public static String hackerrankInString(String s) {
        // Write your code here

        if (s.length() < 10) {
            return "NO";
        }
        s  = s.toLowerCase();
        String str = "hackerrank";

        int count = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(left) == str.charAt(count)) {
                count++;
                left++;
            } else {
                left++;
            }

            if (count == str.length()-1) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {

        String[] strings = {"Ab1", "#HackerRank", "#Hacker1", "hhaackkerrannckk", "hccakeerrank"};
        for (String str : strings) {
            Logger.getLogger(SubsequenceInString.class.getName())
                    .log(Level.INFO, "Has subSequence = {0}", SubsequenceInString.hackerrankInString(str));
        }
    }
}
