package javasolutionsforalgorithms.revision_v2.hackerrank.collection;

/**
 * You are given a binary string of length n. You can perform the following operation on the string:
 * Replace even length substrings with either 0 or 1, in case the substring has a mixture of 0s and 1s.
 * Return the minimum number of operations required to adjust the strings
 *
 * Please note the binary string will be of even length.
 */
public class ReplacementInBinaryString {

    public static void main(String[] args) {
        String binaryString = "1100111001";
        int minOperations = minOperations(binaryString);
        System.out.println("Minimum operations required: " + minOperations);
    }

    public static int minOperations(String binaryString) {
        int n = binaryString.length();
        int operations = 0;

        for (int i = 0; i < n; i += 2) {
            String substring = binaryString.substring(i, i + 2);
            if (substring.equals("01") || substring.equals("10")) {
                operations++;
            }
        }

        return operations;
    }
}
