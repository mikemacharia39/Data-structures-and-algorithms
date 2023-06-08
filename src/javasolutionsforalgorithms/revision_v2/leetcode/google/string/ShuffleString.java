package javasolutionsforalgorithms.revision_v2.leetcode.google.string;

/**
 * <a href="https://leetcode.com/problems/shuffle-string/">...</a>
 *
 * You are given a string s and an integer array indices of the same length. The string s will be shuffled such that
 * the character at the ith position moves to indices[i] in the shuffled string.
 *
 * Example 1:
 * Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * Output: "leetcode"
 * Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
 */
public class ShuffleString {

    /**
     * Using an array to store the characters in their corresponding position
     * @param s string input
     * @param indices array of indices
     * @return shuffled string
     */
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            int x = indices[i];
            arr[x] = s.charAt(i);
        }
        return new String(arr);
    }
}
