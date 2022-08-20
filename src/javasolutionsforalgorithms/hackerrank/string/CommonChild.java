package javasolutionsforalgorithms.hackerrank.string;

/**
 * A string is said to be a child of a another string if it can be formed by deleting 0 or more characters
 * from the other string. Letters cannot be rearranged. Given two strings of equal length,
 * what's the longest string that can be constructed such that it is a child of both?
 *
 * Example 1:
 * s1 = "ABCD" | s2 = "ABDC"
 *
 * Output: 3
 *
 * These strings have two children with maximum length 3, ABC and ABD.
 * They can be formed by eliminating either the D or C from both strings. Return 3.
 *
 * Example 2:
 * s1: HARRY | s2: SALLY
 *
 * Output: 2
 *
 * Explanation:  The longest string that can be formed by deleting zero or more characters from HARRY and SALLY is AY,
 * whose length is 2.
 */
public class CommonChild {

    public static int commonChild(String s1, String s2) {

        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
