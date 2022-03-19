package codility;

/**
 * https://app.codility.com/cert/view/certYH3NQA-CDP76M444PGQHUGC/details/
 * 
 * You are given a string S of length N consisting of characters 'a' and 'b' with additional empty gaps represented by '?'.
 * Your task is to replace every such gap with either an 'a' character or a 'b' character so that the longest fragment of S, consisting only of 'a' characters or 'b' characters, is as short as possible.
 *
 * For example, for S = "aa??bbb", if you replace "??" with "aa", the longest fragment consisting of equal characters will
 * have length 4: "aaaabbb". You can obtain a better result by replacing "??" with "ba", resulting in "aababbb".
 * Then the longest fragment consisting of equal characters will have length 3.
 *
 * Write a function:
 *
 * class Solution { public int solution(String S); }
 *
 * that, given a string S of length N, returns the minimum possible length of the longest fragment of S consisting of equal
 * characters after replacing all "?" characters with letters.
 *
 * Examples:
 *
 * 1. Given S = "aa??bbb", your function should return 3, as explained above.
 *
 * 2. Given S = "a?b?aa?b?a", your function should return 2.
 * Question marks can be replaced in the following way: "aabbaabbaa".
 *
 * 3. Given S = "?????", your function should return 1.
 * There are two possible ways to achieve this length: "ababa" and "babab".
 *
 * 4. Given S = "aa?b?aa", your function should return 3.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * string S consists only of the following characters: "a", "b" and/or "?";
 * N is an integer within the range [1..100,000].
 */
public class FillTheGaps {

    public static String solution(String s) {
        char a = 'a';
        char b = 'b';

        int qPos = s.indexOf("?");

        while (qPos != -1) {
            if (qPos - 1 >= 0 && qPos + 1 < s.length()) {
                if (s.charAt(qPos - 1) == a && s.charAt(qPos + 1) == b) {
                    s = s.substring(0, qPos) + a + s.substring(qPos + 1);
                }
                if (s.charAt(qPos - 1) == a && s.charAt(qPos + 1) == a) {
                    s = s.substring(0, qPos) + b + s.substring(qPos + 1);
                }
                if (s.charAt(qPos - 1) == a && s.charAt(qPos + 1) == '?') {
                    s = s.substring(0, qPos) + a + s.substring(qPos + 1);
                }


                if (s.charAt(qPos - 1) == b && s.charAt(qPos + 1) == a) {
                    s = s.substring(0, qPos) + b + s.substring(qPos + 1);
                }
                if (s.charAt(qPos - 1) == b && s.charAt(qPos + 1) == b) {
                    s = s.substring(0, qPos) + a + s.substring(qPos + 1);
                }
                if (s.charAt(qPos - 1) == b && s.charAt(qPos + 1) == '?') {
                    s = s.substring(0, qPos) + b + s.substring(qPos + 1);
                }
            }
            if (s.indexOf("?") == 0) {
                if (s.charAt(qPos + 1) == b) {
                    s = s.substring(0, qPos) + a + s.substring(qPos + 1);
                }
                if (s.charAt(qPos + 1) == 'a') {
                    System.out.println("s: " + s);
                    s = s.substring(0, qPos) + b + s.substring(qPos + 1);
                }
                if (s.charAt(qPos + 1) == '?') {
                    s = s.substring(0, qPos) + b + s.substring(qPos + 1);
                }
            }
            qPos = s.indexOf("?");
        }

        return s;
    }

    public static void main(String[] args) {
        String[] strings = {"aa??bbb", "aa?b?aa", "a?b?aa?b?a"};
        for (String str : strings) {
            System.out.println("Str " + str + " is now " + FillTheGaps.solution(str));
        }
    }
}
