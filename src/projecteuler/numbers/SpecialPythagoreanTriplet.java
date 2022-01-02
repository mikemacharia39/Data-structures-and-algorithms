package projecteuler.numbers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 *
 * Find the product abc.
 */
public class SpecialPythagoreanTriplet {


    public long specialTriplet(long sum) {
        // Since a < b < c, we can make the assumption a/3 and b/2

        long c = 0;
        for (long a = 1; a <= sum/3; a++) {
            for (long b = a; b <= sum/2; b++) {
                c = sum - a - b;
                long cSq = a*a + b*b;

                if (cSq == c * c) {
                    return findProduct(a, b, c);
                }
            }
        }
        return 0;
    }

    private long findProduct(long a, long b, long c) {
        return a * b * c;
    }

    public static void main(String[] args) {
        SpecialPythagoreanTriplet specialPythagoreanTriplet = new SpecialPythagoreanTriplet();

        long[] sums = {50, 1000};

        for(long sum : sums) {
            Object[] obj = {sum, specialPythagoreanTriplet.specialTriplet(sum)};
            Logger.getLogger(SpecialPythagoreanTriplet.class.getName()).log(Level.INFO,
                    "The sum {0} has the product of its pythagorean triplet as {1}", obj);
        }
    }
}
