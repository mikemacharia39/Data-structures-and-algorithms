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
}

class Results {
    public static void main(String[] args) {
        String s = "if man was meant to stay on the ground god would have given us roots";

        System.out.println(Encryption.encryption(s));
    }
}
