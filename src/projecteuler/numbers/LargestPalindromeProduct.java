package projecteuler.numbers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://projecteuler.net/problem=4
 *
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class LargestPalindromeProduct {


    public long largestPalindromeFromTwo3DigitNumber() {

        long greatest = 0;

        for (long j = 999; j >= 1; j--) {

            for (long i = 999; i >= 1; i--) {

                long multiplied = i*j;

                if (multiplied == reversedNumber(multiplied)) {

                    Logger.getLogger(LargestPalindromeProduct.class.getName())
                            .log(Level.INFO, "Digits: {0}", i +" "+ j);

                    greatest = Math.max(multiplied, greatest);
                }
            }
        }

        return greatest;
    }

    private long reversedNumber(long num) {

        long reversed = 0;

        while (num > 0) {

            reversed = reversed * 10 + num%10;

            num = num/10;
        }

        return reversed;
    }

    public static void main(String[] args) {
        LargestPalindromeProduct largestPalindromeProduct = new LargestPalindromeProduct();

        Logger.getLogger(LargestPalindromeProduct.class.getName())
                .log(Level.INFO, "largest palindrome made from the product of two 3-digit number = {0}",
                        largestPalindromeProduct.largestPalindromeFromTwo3DigitNumber());
    }
}
