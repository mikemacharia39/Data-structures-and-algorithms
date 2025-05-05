package javasolutionsforalgorithms.revision_v2.leetcode.arrays;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 */
public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        // use string builders to save the pattern row-wise
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        // initialize the string builders
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        int stringLength = s.length();
        char[] arr = s.toCharArray();
        int start = 0;

        while (start < stringLength) {
            // GO DOWN
            for (int j = 0; j < numRows && start < stringLength; j++) {
                stringBuilders[j].append(arr[start++]);
            }

            // GO UP, but start from the second row
            for (int j = numRows - 2; j > 0 && start < stringLength; j--) {
                stringBuilders[j].append(arr[start++]);
            }
        }

        // combine all results
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(stringBuilders[i].toString());
        }
        return result.toString();
    }
}
