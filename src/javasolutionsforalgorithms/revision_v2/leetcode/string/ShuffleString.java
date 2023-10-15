package javasolutionsforalgorithms.revision_v2.leetcode.string;

/**
 * You are given a string s and an integer array indices of the same length. The string s will be shuffled such that
 * the character at the ith position moves to indices[i] in the shuffled string.
 *
 * Example 1:
 *
 *
 * Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * Output: "leetcode"
 * Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
 */
public class ShuffleString {

    public String restoreString(String s, int[] indices) {

        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int currPos = indices[i];
            // at position 4 assign character at position 0 of the string
            // at position 5 assign character at position 1 of the string
            result[currPos] = s.charAt(i);
        }

        return new String(result);
    }
}
