package javasolutionsforalgorithms.general;

import java.util.Arrays;

/**
 * This class is a solution to the following problem:
 * to find the difference between the largest and smallest digits of a number
 */
public class DifferenceMaxAndMinOfNo {

    public static int numOfDiffCountBetweenSmallestAndLargestDigitsOfANumber(int n) {

        int numSortedAsc = sortDigitsOfANumber(n);

        int numOfDigits = countDigitsInNum(numSortedAsc);

        int numSortedDesc = reverseDigitsOfANumber(numSortedAsc);

        System.out.printf("numSortedAsc: %d, numSortedDesc: %d, number of digits in sorted: %d%n",
                numSortedAsc, numSortedDesc, numOfDigits);

        return numSortedDesc - numSortedAsc;
    }

    public static int sortDigitsOfANumber(int n) {
        int[] digits = new int[10];

        // the digits array will contain the count of each digit in the number
        while (n > 0) {
            digits[n % 10]++; // increment the count of the digit in a specific index
            n /= 10;
        }

        System.out.println(Arrays.toString(digits));


        // now we will iterate over the digits array and create the number
        int ans = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 0) {
                while (digits[i]-- > 0) { // loop through, while the count of the digit is greater than 0, reduce digits
                    ans = ans * 10 + i;
                }
            }
        }

        return ans;
    }

    public static int reverseDigitsOfANumber(int n) {
        int ans = 0;

        while (n > 0) {
            int modulus = n % 10;

            ans = ans * 10 + modulus;

            n /= 10;
        }

        return ans;
    }

    public static int countDigitsInNum(int num) {
        int count = 0;

        while (num > 0) {
            num /= 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int num = 6124;
        System.out.printf("Original num: %d, result: %d", num, numOfDiffCountBetweenSmallestAndLargestDigitsOfANumber(num));

        System.out.println();

        int num2 = 261421;
        System.out.printf("Original num: %d, result: %d", num2, numOfDiffCountBetweenSmallestAndLargestDigitsOfANumber(num2));
    }
}
