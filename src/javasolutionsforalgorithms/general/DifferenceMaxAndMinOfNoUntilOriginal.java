package javasolutionsforalgorithms.general;

import java.util.Arrays;

/**
 * This class is a solution to the following problem:
 * to find the difference between the largest and smallest digits of a number until the original number is obtained.
 * The number is limited to 4 digits.
 *
 * You can also assume that in the case after 10 repetitions the number is still not the original number,
 * then return -1.
 *
 * Example:
 * num: 6174
 * count: 1, diff: 6174
 *
 * Explanation:
 * 7641 - 1467 = 6174
 *
 * Example 2:
 * num: 8
 * count: -1
 */
public class DifferenceMaxAndMinOfNoUntilOriginal {

    public static int countNoOfDiffUntilOriginalNumIsObtained_has_good_concepts(int num) {
        int counter = 1;// Initialize a counter variable to 0
        int original = num;// Store the original number
        while (counter < 10) {// Loop up to 10 times
            int[] digits = new int[4];// Create an array to store the digits
            int i = 3;
            while (i >= 0) {// Extract the digits and store them in the array
                digits[i] = num % 10;
                num /= 10;
                i--;
            }
            Arrays.sort(digits);// Sort the digits in ascending order
            int smallest = digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];// Calculate the smallest number that can be formed
            int largest = digits[3] * 1000 + digits[2] * 100 + digits[1] * 10 + digits[0];// Calculate the largest number that can be formed

            System.out.printf("smallest: %d, largest: %d%n", smallest, largest);

            int diff = largest - smallest;// Calculate the difference between the largest and smallest numbers
            if (diff == original) {// Check if the difference is equal to the original number
                return counter;// If so, return the number of iterations performed
            }
            num = diff;// Otherwise, set the input number to the difference and continue the loop
            counter++;// Increment the counter
        }
        return -1;// Return -1 if the original number is not obtained after 10 iterations
    }

    public static int countNoOfDiffUntilOriginalNumIsObtained(int num) {
        int count = 0;
        int original = num;

        while (findDiff(num) != original) {
            num = findDiff(num);
            count++;
            System.out.println("count: " + count + ", diff: " + num);

            if (count > 10 || num == 0) {
                count = -1;
                break;
            }
        }

        return count;
    }

    public static int findDiff(int num) {
        int sortNum = sortDigitOfNumInAsc(num);
        int reverseNum = reverseDigitsOfANumber(sortNum);
        System.out.printf("numSortedAsc: %d, numSortedDesc: %d%n",
                sortNum, reverseNum);
        return Math.abs(reverseNum - sortNum);
    }

    public static int sortDigitOfNumInAsc(int num) {
        int[] digits = new int[10];

        // the digits array will contain the count of each digit in the number
        // e.g. 1234 will be stored as [0, 1, 1, 1, 1, 0, 0, 0, 0, 0]
        while (num > 0) {
            int modulus = num % 10;
            digits[modulus]++;
            num /= 10;
        }

        // now we will iterate over the digits array and create the number
        int ans = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 0) {
                while (digits[i]-- > 0) {
                    ans = ans * 10 + i;
                }
            }
        }
        return ans;
    }

    public static int reverseDigitsOfANumber(int num) {
        int ans = 0;

        while (num > 0) {
            int modulus = num % 10;
            ans = ans * 10 + modulus;
            num /= 10;
        }

        return padNumWithZerosWhenLessThan4Digits(ans);
    }

    public static int padNumWithZerosWhenLessThan4Digits(int num) {
        int ans = 0;

        if (num < 10) {
            ans = num * 1000;
        } else if (num < 100) {
            ans = num * 100;
        } else if (num < 1000) {
            ans = num * 10;
        } else {
            ans = num;
        }

        return ans;
    }

    public static void main(String[] args) {
        int num = 6174;
        System.out.println("num: " + num);
        System.out.println("countNoOfDiffUntilOriginalNumIsObtained: " + countNoOfDiffUntilOriginalNumIsObtained(num));

        System.out.println("====================================");

        int num2 = 8;
        System.out.println("num: " + num2);
        System.out.println("countNoOfDiffUntilOriginalNumIsObtained: " + countNoOfDiffUntilOriginalNumIsObtained(num2));
    }
}
