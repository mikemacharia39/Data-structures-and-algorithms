package hackerrank.string;

/**
 * We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second
 * string. In other words, both strings must contain the same exact letters in the same exact frequency.
 * For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.
 *
 * Alice is taking a cryptography class and finding anagrams to be very useful.
 * She decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of
 * character deletions required to make the two strings anagrams. Can you help her find this number?
 *
 * Given two strings, s1 and s2, that may not be of the same length, determine the minimum number of character deletions
 * required to make s1 and s2 anagrams. Any characters can be deleted from either of the strings.
 *
 * Sample Input:
 *
 * s1: cde
 * s2: abc
 *
 * Output: 4
 * Explanation
 *
 * Delete the following characters from our two strings to turn them into anagrams:
 *
 * Remove d and e from cde to get c.
 * Remove a and b from abc to get c.
 */
public class MakingAnagrams {


    public int makingAnagrams(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int count = 0;

        for (char c : s1.toCharArray()) {
            if (s2.indexOf(c) != -1) {
                s2 = s2.substring(0, s2.indexOf(c)) + s2.substring(s2.indexOf(c)+1);
                count++;
                System.out.println("s1: " + s1 + " | s2: " + s2 + " | count: " + count);
            }
        }

        return s1Len + s2Len - (2*count);
    }

    public static void main(String[] args) {
        MakingAnagrams makingAnagrams = new MakingAnagrams();
        String s1 = "cde";
        String s2 = "abc";
        System.out.println("Deletions: " + makingAnagrams.makingAnagrams(s1, s2));
    }
}
