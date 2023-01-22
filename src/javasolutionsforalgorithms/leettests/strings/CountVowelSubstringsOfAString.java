package javasolutionsforalgorithms.leettests.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/count-vowel-substrings-of-a-string/">...</a>
 *
 * A substring is a contiguous (non-empty) sequence of characters within a string.
 * A vowel substring is a substring that only consists of vowels ('a', 'e', 'i', 'o', and 'u') and has all
 * five vowels present in it.
 * Given a string word, return the number of vowel substrings in word.
 *
 * Example 1:
 *
 * Input: word = "aeiouu"
 * Output: 2
 * Explanation: The vowel substrings of word are as follows (underlined):
 * - "aeiouu"
 * - "aeiouu"
 */
public class CountVowelSubstringsOfAString {

    /**
     * Pretty good solution
     * @param word word
     * @return number of contiguous vowels
     */
    public int countVowelSubstrings(String word) {
        int vow = 0;
        int n = word.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n - 4; i++) {
            set.clear();
            for (int j = i; j < n; j++) {
                char ch = word.charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    set.add(ch);
                    if (set.size() == 5)
                        vow++;
                } else
                    break;
            }
        }
        return vow;
    }

    /**
     * Brute force solution, for easy understanding
     */
    public int countVowelSubstringsSln1(String word) {
        if (word.length() < 5) return 0;
        int count = 0;
        int n = word.length();
        for (int i = 0; i < n-4; i++) {
            for (int j = i; j < n+1; j++) {
                String sub = word.substring(i,j);
                count += hasVowelSubString(sub) ? 1 : 0;
            }
        }

        return count;
    }

    private boolean hasVowelSubString(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        String vowels = "aeiou";

        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) == -1) {
                return false;
            }
            set.remove(s.charAt(i));
        }

        return set.isEmpty();
    }
}
