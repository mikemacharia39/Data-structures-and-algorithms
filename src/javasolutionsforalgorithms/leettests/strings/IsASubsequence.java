package javasolutionsforalgorithms.leettests.strings;

import java.util.*;

/**
 * Write a Java function that checks if a string xyz is a subsequence of another string eeyxdgyz
 */
public class IsASubsequence {

    // these are all solutions I got from chatGPT

    /**
     * Yes, using a HashMap can further optimize the function.
     * The idea is to create a HashMap where the keys are the characters of the eeyxdgyz and the values are the
     * indices of those characters. Then we can iterate through the characters of xyz, and check if the
     * HashMap contains the current character and if it does, check if the index of the current character in the
     * HashMap is greater than the index of the previous character, if so, we continue iterating and if not we return false.
     * @param xyz small string
     * @param eeyxdgyz large string
     * @return true|false
     */
    public static boolean isSubsequence(String xyz, String eeyxdgyz) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < eeyxdgyz.length(); i++) {
            char c = eeyxdgyz.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        int prev = -1;
        for (char c : xyz.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            List<Integer> indices = map.get(c);
            int j = Collections.binarySearch(indices, prev);
            if (j < 0) {
                j = -j - 1;
            }
            if (j == indices.size()) {
                return false;
            }
            prev = indices.get(j);
        }
        return true;
    }

    /**
     * This function uses a single variable index to keep track of the position of the last found
     * character of sub in str. It iterates through the characters of sub using a for-each loop,
     * and for each character, it calls the indexOf method on str starting from the position after the
     * last found character. If a character is not found, the function returns false.
     * If all characters are found, the function returns true.
     *
     * Another optimization would be to convert the string str into a HashSet or HashMap and then
     * iterate through the characters of sub and check if the HashMap or HashSet contains the character in sub or not.
     * @param sub small string
     * @param str large string
     * @return true|false
     */
    public boolean isSubsequence2(String sub, String str) {
        int index = -1;

        for (char c : sub.toCharArray()) {
            index = str.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }


    /**
     * This function uses two pointers, i and j, to iterate through the characters of the two strings.
     * If the characters at the current positions of the pointers match, the i pointer is incremented.
     * In any case, the j pointer is incremented.
     * If at the end of the loop, i is equal to the length of sub, that means that all characters of sub have been
     * found in str in order, so the function returns true. Otherwise, false is returned.
     *
     * @param sub small string
     * @param str large string
     * @return true|false
     */
    public boolean isSubsequence1(String sub, String str) {
        if (sub.length() > str.length()) return false;

        int i = 0;
        int j = 0;

        while (i < sub.length() && j < str.length()) {
            if (sub.charAt(i) == str.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == sub.length();
    }

    public static void main(String[] args) {
        IsASubsequence aSubsequence = new IsASubsequence();
        String sub = "xyz";
        String str = "xyeyeoouexdgdydhz";

        System.out.println("Is subsequence: " + aSubsequence.isSubsequence(sub, str));
    }
}
