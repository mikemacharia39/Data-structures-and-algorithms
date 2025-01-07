package javasolutionsforalgorithms.projecteuler.numbers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 * https://www.mathblog.dk/project-euler-solutions/
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */
public class SummationOfPrimes {

    public long summationOfPrimes(long max) {
        long sum = 0;
        for (long i = 0; i < max; i++) {
            sum = isPrimeNumber(i) ? sum + i: sum;
        }

        return sum;
    }
    
    private boolean isPrimeNumber(long num) {
        
        if (num <= 1) {
            return false;
        }
        // We do Math.sqrt(num) to reduce the number of iterations, because if a number is not a prime
        // it will have a factor less than or equal to its square root
        // e.g. 100, the factors are 1, 2, 4, 5, 10, 20, 25, 50, 100
        // 100 is not a prime number because it has factors less than or equal to its square root
        // e.g. 17, the factors are 1, 17
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num%i == 0) {
                return false;
            }
        }
        
        return true;
    }
    

    public static void main(String[] args) {
        SummationOfPrimes summationOfPrimes = new SummationOfPrimes();

        long[] nums = {10, 2000000};

        for(long num : nums) {
            Object[] obj = {num, summationOfPrimes.summationOfPrimes(num)};
            Logger.getLogger(SummationOfPrimes.class.getName()).log(Level.INFO,
                    "The sum of the primes below {0} is {1}", obj);
        }
    }
}
