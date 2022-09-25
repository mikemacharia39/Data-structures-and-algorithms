package javasolutionsforalgorithms.hackerrank.string;

import java.util.Scanner;

/**
 *
 * <a href="https://www.hackerrank.com/challenges/java-string-tokens/problem">...</a>
 *
 * Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens.
 * We define a token to be one or more consecutive English alphabetic letters.
 * Then, print the number of tokens, followed by each token on a new line.
 *
 * Note: You may find the String.split method helpful in completing this challenge.
 *
 * Input Format
 *
 * A single string, s.
 *
 * is composed of any of the following: English alphabetic letters, blank spaces, exclamation points (!), commas (,),
 * question marks (?), periods (.), underscores (_), apostrophes ('), and at symbols (@).
 * Output Format
 *
 * On the first line, print an integer,n , denoting the number of tokens in string s (they do not need to be unique).
 * Next, print each of the n tokens on a new line in the same order as they appear in input string s.
 */
public class JavaStringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        s = s.trim();
        if (s.length() == 0) {
            System.out.println(0);
        } else {
            String[] splStrings = s.split("[ !,?._'@]+");
            StringBuilder sb = new StringBuilder();
            sb.append(splStrings.length);
            for (String str : splStrings) {
                sb.append("\n");
                sb.append(str);
            }
            System.out.println(sb);
        }
        scan.close();
    }
}
