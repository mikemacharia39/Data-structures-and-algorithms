package hackerrank.arrays;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
 * Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
 *
 * Example 1:
 * s = mom
 * The list of all anagrammatic pairs is [m,m] and [mo,om]
 * Output: 2
 *
 * Function Description
 *
 * Complete the function sherlockAndAnagrams in the editor below.
 *
 * sherlockAndAnagrams has the following parameter(s):
 *
 * string s: a string
 * Returns
 *
 * int: the number of unordered anagrammatic pairs of substrings in s
 *
 * Example 2:
 * Input  = ifailuhkqq
 * Output = 3
 *
 * Example 3:
 * input  = kkkk
 * output = 10
 *
 */
public class SherLockAndAnagrams {

    public static int sherlockAndAnagrams(String s) {
        // ifailuhkqq
        // kkkk
        // cdcd

        int count = 0;
        int start = 0;
        while (start <= s.length()) {
            for (int i = start; i < s.length(); i++) {
                String sub1 = s.substring(start, i+1);
                int mStart = 0;
                while (mStart <= s.length() - i) {

                    for (int j = mStart; j < s.length() - i; j++) {
                        String sub2 = "";
                        for (int k = j+1; k < s.length() - i + 1; k++) {
                            sub2 = s.substring(j, k);
                            if (i != j && isAnagram(sub1, sub2)) {
                                count++;
                            }
                        }
                    }

                    mStart++;
                }

            }
            start++;
        }


        return count;
    }

    public static boolean isAnagram(String a, String b) {
        int[] a1 = toIntArr(a);
        int[] b1 = toIntArr(b);

        return Arrays.equals(a1, b1);
    }

    private static int[] toIntArr(String s) {
        int[] arr = new int[26];

        for (int i = 0; i< s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        return arr;
    }

    public static void main(String[] args) {
        //String[] input = {"ifailuhkqq", "kkkk", "cdcd", "abcd"};
        String[] input = {"cdcd"};

        for (String str : input) {
            Logger.getLogger("SherLockAndAnagrams")
                    .log(Level.INFO, "String  {0}", str + " = "+ sherlockAndAnagrams(str));
        }
    }
}
