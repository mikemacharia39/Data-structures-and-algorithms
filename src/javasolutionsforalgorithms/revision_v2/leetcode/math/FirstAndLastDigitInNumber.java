package javasolutionsforalgorithms.revision_v2.leetcode.math;

public class FirstAndLastDigitInNumber {


    /**
     * This is a simple math problem. We can find the first digit by dividing the number by 10 until the number is less than 10.
     * Time complexity: 0(log(n))
     * @param n the number
     * @return the first digit
     */
    public static int firstDigit(int n) {
        while (n >= 10) {
            n = n / 10;
        }
        return n;
    }
}
