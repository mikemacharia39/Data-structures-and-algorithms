package javasolutionsforalgorithms.leettests;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * https://leetcode.com/problems/valid-anagram/
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class ValidAnagramStrings {

    public static void main(String[] args) {
        ValidAnagramStrings anagramStrings = new ValidAnagramStrings();

        String s = "anagram", t = "nagaram";
//        String s = "mum", t = "mama";
        System.out.println(anagramStrings.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] arroft = toIntArr(s);
        int[] arrofs = toIntArr(t);

        return Arrays.equals(arrofs, arroft);
    }

    private int[] toIntArr(String s) {
        int[] arr = new int[26];

        for (int i = 0; i< s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        return arr;
    }

    public boolean isAnagramSln1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cOfs = s.toCharArray();
        Arrays.sort(cOfs);
        char[] cOft = t.toCharArray();
        Arrays.sort(cOft);

        return Arrays.equals(cOfs, cOft);
    }


}
