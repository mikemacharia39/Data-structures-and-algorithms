package javasolutionsforalgorithms.hackerrank.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending.
 * Determine if the columns are also in ascending alphabetical order, top to bottom.
 * Return YES if they are or NO if they are not.
 *
 * Example 1
 *
 * The grid is illustrated below. grid = ["abc", "ade", "efg"]
 *
 * a b c
 * a d e
 * e f g
 *
 * The rows are already in alphabetical order. The columns a a e, b d f and c e g are also in alphabetical order,
 * so the answer would be YES. Only elements within the same row can be rearranged.
 * They cannot be moved to a different row.
 *
 * Function Description
 *
 * Complete the gridChallenge function in the editor below.
 *
 * gridChallenge has the following parameter(s):
 *
 * string grid[n]: an array of strings
 * Returns
 *
 * string: either YES or NO
 *
 * Sample Input
 * ----------------
 *
 * STDIN   Function
 * -----   --------
 * 1       t = 1
 * 5       n = 5
 * ebacd   grid = ['ebacd', 'fghij', 'olmkn', 'trpqs', 'xywuv']
 * fghij
 * olmkn
 * trpqs
 * xywuv
 *
 *
 * Sample Output
 * YES
 *
 *
 * Explanation
 * The 5 x 5 grid in the  test case can be reordered to
 *
 * abcde
 * fghij
 * klmno
 * pqrst
 * uvwxy
 *
 */
public class GridChallenge {

    public static String gridChallenge(List<String> grid) {

        List<String> sortedGrid = new ArrayList<>();
        for (String str : grid) {
            char[] charStr = str.toCharArray();
            Arrays.sort(charStr);
            sortedGrid.add(new String(charStr));
        }

        if (sortedGrid.size() < 2) {return "YES";}

        int n = sortedGrid.size();
        int strLen = sortedGrid.get(0).length();
        for (int i = 0; i < strLen; i++) {
            for (int j = 1; j < n; j++) {
                if (sortedGrid.get(j-1).charAt(i) > sortedGrid.get(j).charAt(i)) {
                    return "NO";
                }
            }
        }

        return "YES";
    }
}
