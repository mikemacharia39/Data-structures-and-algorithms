package hackerrank.string;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <a href="https://www.hackerrank.com/challenges/reduced-string/problem">...</a>
 * Reduce a string of lowercase characters in range ascii[‘a’..’z’]by doing a series of operations.
 * In each operation, select a pair of adjacent letters that match, and delete them.
 *
 * Delete as many characters as possible using this method and return the resulting string.
 * If the final string is empty, return Empty String
 *
 * Example 1: aab results to b
 *
 * Example 2: aaabccddd results to abd
 *            aaabccddd → abccddd → abddd → abd
 *
 * Example 3: baab → bb → Empty String
 */
public class SuperReducedString {

    public static String reducedString(String s) {
        for (int q = 1; q < s.length(); q++) {
            if (s.charAt(q) == s.charAt(q-1)) {
                s = s.substring(0, q - 1) + s.substring(q + 1);
                q = 0;
            }
        }

        return s.length() == 0 ? "Empty String" : s;
    }

    public static void main(String[] args) {
        String[] s = {"abbbb", "aaabccddd", "baab"};
        for (String x : s) {
            Logger.getLogger(SuperReducedString.class.getName())
                    .log(Level.INFO, "Reduced string: {0}", SuperReducedString.reducedString(x));
        }
    }
}
