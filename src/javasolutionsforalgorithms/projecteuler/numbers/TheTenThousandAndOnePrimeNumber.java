package javasolutionsforalgorithms.projecteuler.numbers;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://projecteuler.net/problem=7
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */
public class TheTenThousandAndOnePrimeNumber {

    /**
     * Time complexity O (n)
     * Space complexity 0 (1)
     *
     * @param maxPosition the max pos
     * @return long
     */
    public long the10001PrimeNumber(int maxPosition) {

        long count = 0;
        long value = 0;

        for (long i = 2; i < Long.MAX_VALUE; i++) {
            if (isPrimeNumber(i)) {
                count++;
            }

            if (count == maxPosition) {
                value = i;
                break;
            }
        }

        return value;
    }

    public boolean isPrimeNumber(long number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number%i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        TheTenThousandAndOnePrimeNumber primeNumber = new TheTenThousandAndOnePrimeNumber();

        int maxPos = 10001;

        Logger.getLogger(TheTenThousandAndOnePrimeNumber.class.getName())
                .log(Level.INFO, "The {0}", maxPos + " Number is: "
                        + primeNumber.the10001PrimeNumber(maxPos));

    }
}
