package javasolutionsforalgorithms.revision_v2.hackerrank.array;

/**
 * To find the reverse of a number, we can use the modulo operator (%) to extract the last digit and
 * the division operator (/) to remove the last digit.
 */

public class ReverseInteger {

    /**
     * TimeComplexity: O(log10 n) because we are dividing the input by 10 in each iteration
     * @param num
     * @return
     */
    public static int reverseInteger(int num) {

        int result = 0;

        while(num > 0) {
            int remainder = num % 10;
            num = num / 10;

            // edge case
            // explain: when result is 214748364, remainder is 8, and num is 7, then result * 10 + remainder will be 2147483648,
            // which is greater than Integer.MAX_VALUE
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && remainder > 7)) return 0;

            result = (result * 10) + remainder;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] testNumbers = {123, 321, 100, 0, 1, 10, 1000000003};
        for (int num : testNumbers) {
            System.out.println("reverseInteger(" + num + ") = " + reverseInteger(num));
        }
    }
}
