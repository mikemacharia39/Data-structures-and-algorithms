package javasolutionsforalgorithms.hackerrank.string;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * https://www.hackerrank.com/challenges/strong-password/problem
 * Louise joined a social networking site to stay in touch with her friends.
 * The signup page required her to input a name and a password. However, the password must be strong.
 * The website considers a password to be strong if it satisfies the following criteria:
 *
 * Its length is at least 6.
 * It contains at least one digit.
 * It contains at least one lowercase English character.
 * It contains at least one uppercase English character.
 * It contains at least one special character. The special characters are: !@#$%^&*()-+
 * She typed a random string of length n  in the password field but wasn't sure if it was strong.
 * Given the string she typed, can you find the minimum number of characters she must add to make her password strong?
 *
 * Note: Here's the set of types of characters in a form you can paste in your solution:
 *
 * numbers = "0123456789"
 * lower_case = "abcdefghijklmnopqrstuvwxyz"
 * upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
 * special_characters = "!@#$%^&*()-+"
 * -------------------------------------------
 * Example 1
 *
 * length = 3
 * password = Ab1
 *
 * Output = 3
 *
 * Explanation: She can make the password strong by adding 3 characters, for example, $hk, turning the
 * password into Ab1$hk which is strong.
 *
 * 2 characters aren't enough since the length must be at least 6.
 *
 * ------------------------
 *
 * Example 2
 *
 * length = 11
 * password = #HackerRank
 * Sample Output 1
 *
 * output = 1
 *
 * Explanation: The password isn't strong, but she can make it strong by adding a single digit.
 *
 */
public class StringPassword {

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong

        String numbers = "(\\d)";
        String lowerCase = "([a-z])";
        String upperCase = "([A-Z])";
        String specialCharacters = "(\\W)";//"([!@#$%^&*()-+])";
        //(\\W) - any now word character
        //([a-zA-Z0-9]*) - Also works in place if check any non word or non digit

        Pattern patternNums = Pattern.compile(numbers);
        Pattern patternLC = Pattern.compile(lowerCase);
        Pattern patternUC = Pattern.compile(upperCase);
        Pattern patternSC = Pattern.compile(specialCharacters);

        Matcher matcherNums = patternNums.matcher(password);
        Matcher matcherLC = patternLC.matcher(password);
        Matcher matcherUC = patternUC.matcher(password);
        Matcher matcherSC = patternSC.matcher(password);

        int count = 0;
        if (!matcherNums.find()) {
            count++;
        }

        if (!matcherLC.find()) {
            count++;
        }

        if (!matcherUC.find()) {
            count++;
        }

        if (!matcherSC.find()) {
            count++;
        }

        int lengthDiff = 6 - (count + n);

        if (lengthDiff > 0) {
            count = count + ((n < 6) ? (6 - (count + n)) : 0);
        }
        return count;
    }


    public static void main(String[] args) {

        String[] passwords = {"Ab1", "#HackerRank", "#Hacker1", "TheN!nj@", "TheQuickDog"};

        for (String password:passwords) {
            Logger.getLogger(StringPassword.class.getName()).
                    log(Level.INFO, "Missing are: {0}", StringPassword.minimumNumber(password.length(), password));
        }
    }
}
