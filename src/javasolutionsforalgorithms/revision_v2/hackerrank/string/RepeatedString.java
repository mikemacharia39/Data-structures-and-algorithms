package javasolutionsforalgorithms.revision_v2.hackerrank.string;

import java.util.HashMap;
import java.util.Map;

/**
 * There is a string, s, of lowercase English letters that is repeated infinitely many times. Given an integer, n,
 * find and print the number of letter a's in the first n letters of the infinite string.
 *
 * Example:
 * s = 'abcac'
 * n = 10
 * The substring we consider is abcacabcac, the first 10 characters of the infinite string. There are 4 occurrences
 * of a in the substring.
 */
public class RepeatedString {

    public static long repeatedString(String s, long n) {
        long strLen = s.length();

        long countPerChunk = 0;
        char a = 'a';
        for (int i = 0; i < strLen; i++) {
            if (a == s.charAt(i)) {
                countPerChunk += 1;
            }
        }

        if (strLen == n) {
            return countPerChunk;
        }

        long chunks = n/strLen;

        long rem = n%strLen;

        long totalSum = countPerChunk * chunks;

        for (int j = 0; j < rem; j++) {
            if (a == s.charAt(j)) {
                totalSum += 1;
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {
        Map<String, Long> testCases = Map.of(
                "aba", 10L, "a", 1000000000000L, "abcac", 10L
        );

        for (Map.Entry<String, Long> entry : testCases.entrySet()) {
            System.out.println(repeatedString(entry.getKey(), entry.getValue()));
        }
    }
}
