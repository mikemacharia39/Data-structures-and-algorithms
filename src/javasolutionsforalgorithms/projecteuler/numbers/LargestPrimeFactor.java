package javasolutionsforalgorithms.projecteuler.numbers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 * Explanation
 * A factor that is a prime number. In other words: any of the prime numbers that can be multiplied to give the
 * original number. Example: The prime factors of 15 are 3 and 5 (because 3×5=15, and 3 and 5 are prime numbers).
 */
public class LargestPrimeFactor {

    /**
     * prime numbers are
     * @param num the number
     * @return list of prime numbers
     */
    public List<Long> primeFactors(long num) {
        BigDecimal number = new BigDecimal("600851475143");
        num = number.longValue();

        List<Long> primeNo = new ArrayList<>();

        if (num <= 1) {
            primeNo.add(num);
            return primeNo;
        }

        for (long i = (long)Math.sqrt(num); i >= 2; i--) {

            if (isPrimeNum(i) && num%i == 0) {
                primeNo.add(i);

                num = num / i;
            }
        }

        return primeNo;
    }

    /**
     * Determining a prime number
     * @param num number
     * @return true|false
     */
    private boolean isPrimeNum(long num) {

        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        long val = 600851475;//600851475143;
        long val2 = 600851475;

        LargestPrimeFactor largestPrimeFactor = new LargestPrimeFactor();

        List<Long> factors = largestPrimeFactor.primeFactors(val2);
        Logger.getLogger(LargestPrimeFactor.class.getName())
                .log(Level.INFO, "Prime factors: {0}", factors);


        Logger.getLogger(LargestPrimeFactor.class.getName())
                .log(Level.INFO, "Largest factor is: {0}", factors.get(0));
    }
}
