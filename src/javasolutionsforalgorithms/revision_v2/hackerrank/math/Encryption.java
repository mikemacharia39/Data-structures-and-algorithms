package javasolutionsforalgorithms.revision_v2.hackerrank.math;

/**
 * <a href="https://www.hackerrank.com/challenges/encryption/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign">...</a>
 *
 * An English text needs to be encrypted using the following encryption scheme.
 * First, the spaces are removed from the text. Let L be the length of this text.
 * Then, characters are written into a grid, whose rows and columns have the following constraints:
 * sqrt(L) <= row <= column <= sqrt(L), where floor is the floor function and ceil is the ceiling function.
 *
 * Example:
 * if man was meant to stay on the ground god would have given us roots
 *
 * Answer: imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau
 * Explanation:
 * After removing spaces, the string is 54 characters long. sqrt 54 is between 7 and 8, so it is written in the form
 * of a grid with 7 rows and 8 columns.
 *
 * ifmanwas
 * meanttos
 * tayonthe
 * groundgo
 * dwouldha
 * vegivenu
 * sroots
 *
 */
public class Encryption {

    /**
     * Solution 1
     * Time complexity = O(n), where n is the length of the string
     * Space complexity = O(n), because of the string builder
     * Explanation: The logic is to remove the spaces from the string and then calculate the number of rows and columns
     * based on the length of the string. Then, we iterate through the columns and add the characters to the string builder.
     * @param s
     * @return
     */
    public static String encryption(String s) {
        s = s.replaceAll(" ", "");
        int len = s.length();
        int row = (int) Math.floor(Math.sqrt(len));
        int col = (int) Math.ceil(Math.sqrt(len));

        if (row * col < len) {
            row = col;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < col; i++) {
            for (int j = i; j < len; j += col) { // j += col is to move to the next column
                sb.append(s.charAt(j));
            }
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    /**
     * Solution 2
     * Time complexity = O(n), where n is the length of the string
     * Space complexity = O(n), because of the grid we have introduced
     * @param s
     * @return
     */
    public static String encryption1(String s) {
        s = s.replace(" ", "");
        int len = s.length();
        int row = (int) Math.floor(Math.sqrt(len));
        int col = (int) Math.ceil(Math.sqrt(len));

        if (row * col < len) {
            row = col;
        }

        char[][] grid = new char[row][col];
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col && k < len; j++) {
                grid[i][j] = s.charAt(k++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[j][i] != 0) { // this checks if the character is not empty
                    sb.append(grid[j][i]);
                }
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}

class Results {
    public static void main(String[] args) {
        String s = "if man was meant to stay on the ground god would have given us roots";

        System.out.println(Encryption.encryption(s));
        // solution 2

        System.out.println(Encryption.encryption1(s));
    }
}
