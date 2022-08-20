package javasolutionsforalgorithms.projecteuler.numbers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
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
