package hackerrank.string;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * James found a love letter that his friend Harry has written to his girlfriend.
 * James is a prankster, so he decides to meddle with the letter. He changes all the words in the letter into palindromes.
 *
 * To do this, he follows two rules:
 *
 * He can only reduce the value of a letter by , i.e. he can change d to c, but he cannot change c to d or d to b.
 * The letter  may not be reduced any further.
 * Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations required to convert a given string into a palindrome.
 *
 * Example
 * cde
 *
 * Example 1: For the first query, abc → abb → aba  = 2
 * Example 2: abcba is already a palindromic string.
 * Example 3: abcd → abcc → abcb → abca → abba      = 4
 * Example 4: For the fourth query, cba → bba → aba.
 *
 * The following two operations are performed: cde → cdd → cdc. Return 2.
 */
public class LovePalindromeMystery {

    /**
     * The answer to this is to subtract the left and right of each character ASCII value
     * @param s string
     * @return number of changes
     */
    public static int theLoveLetterMystery(String s) {
        int sLen = s.length();
        int count = 0;
        int j = sLen - 1;
        for (int i = 0; i < sLen/2; i++) {
            count += Math.abs(s.charAt(i) - s.charAt(j));

            j--;
        }

        return count;
    }

    public static void main(String[] args) {
        String[] s = {"abc", "abcd", "abbc"};

        for (String str : s) {
            Object[] objects = {str, LovePalindromeMystery.theLoveLetterMystery(str)};
                    Logger.getLogger(LovePalindromeMystery.class.getName())
                            .log(Level.INFO, "For str {0} the minimum number of changes is {1}", objects);
        }
    }
}
