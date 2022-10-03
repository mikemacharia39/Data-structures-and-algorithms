package javasolutionsforalgorithms.leettests.dynamicprogramming;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 *
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 *
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 */
public class LongestCommonSubsequence {

    /**
     * Explanation
     * <a href="https://www.youtube.com/watch?v=HgUOWB0StNE&ab_channel=GeeksforGeeks">...</a>
     *
     * @param text1 text1
     * @param text2 text2
     * @return max length
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }

    //=========== DOES NOT WORK =================

    public int longestCommonSubsequenceDidNotWork(String text1, String text2) {

        int counter = 0;

        int prevIndex = 0;
        int max = 0;
        for (char c : text1.toCharArray()) {
            int curIndex = text2.indexOf(c);
            if (curIndex != -1) {
                if (prevIndex > curIndex) {
                    max = Math.max(max, counter);
                    counter = 0;
                }
                counter++;
                prevIndex = curIndex;
                text2 = text2.substring(0, curIndex) + text2.substring(curIndex+1);
            }
        }

        return Math.max(counter, max);
    }
}
