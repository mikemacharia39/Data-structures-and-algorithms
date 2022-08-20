package javasolutionsforalgorithms.hackerrank.string;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Alice has a binary string.
 * She thinks a binary string is beautiful if and only if it doesn't contain the substring 010.
 *
 * In one step, Alice can change a 0 to a 1 or vice versa.
 * Count and print the minimum number of steps needed to make Alice see the string as beautiful.
 *
 * Example 1: 010
 *
 * She can change any one element and have a beautiful string.
 *
 * Function Description
 *
 * Complete the beautifulBinaryString function in the editor below.
 *
 * beautifulBinaryString has the following parameter(s):
 *
 * string b: a string of binary digits
 * Returns
 *
 * int: the minimum moves required
 */
public class BeautifulBinaryString {

    /**
     * @param x binary string
     * @return minumum number of changes
     */
    public static int beautifulBinaryString2(String x) {
        String searchString = "010";
        int count = 0;
        for (int i = 0; i <= x.length()-1;) {
            if (searchString.equals(searchString.substring(i, i+3))) {
                count++;
                i = i+3;
            } else {
                i++;
            }
        }
        return count;
    }

    /**
     * This guy is a genius - I couldn't have thought of this
     * @param x binary string
     * @return minumum number of changes
     */
    public static int beautifulBinaryString(String x) {
        String searchString = "010";
        // 010 010 1 010
        // 10 - 1 = 9/3 = 3
        // 010
        // 3 - 0 = 3/3 = 1
        // the division by 3 is because of the length of the search string
        return (x.length() - x.replaceAll(searchString, "").length())/3;
    }

    public static void main(String[] args) {

        String[] binaryStrings = {"010", "0100101010", "01001100101", "01001011100010101"};
        for (String binaryString : binaryStrings) {
            Logger.getLogger(BeautifulBinaryString.class.getName())
                    .log(Level.INFO, "Number of changes: {0}",
                            BeautifulBinaryString.beautifulBinaryString(binaryString));
        }

    }
}
