package projecteuler.numbers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ..... + 10^2=385
 *
 * The square of the sum of the first ten natural numbers is,
 * (1+2+..+10) = 55^2 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is .
 * 3025-385=2640
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum
 */
public class SumSquareDifference {


    public int squareOfSum(int max) {

        // sum of digits in a sequence is n(n+1)/2

        int sum = max * (max + 1)/2;

        return (sum * sum);
    }

    public int sumOfSquare(int max) {

        int sum = 0;
        for (int i = 1; i <= max; i++) {
            sum += (i*i);
        }

        return sum;
    }

    public static void main(String[] args) {
        SumSquareDifference sumSquareDifference = new SumSquareDifference();

        int max = 100;

        int diff = sumSquareDifference.squareOfSum(max) - sumSquareDifference.sumOfSquare(max);

        Logger.getLogger(SumSquareDifference.class.getName()).log(Level.INFO, "Difference: {0}", diff);
    }
}
