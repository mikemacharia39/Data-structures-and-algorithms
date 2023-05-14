package javasolutionsforalgorithms.general;

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
 *
 */
public class DifferenceMaxAndMinOfNoUntilOriginal {

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
