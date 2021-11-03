package projecteuler.numbers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
class NaturalNumbersBelow1000 {

    public int numbersBelow1000(int num1, int num2, int max) {

        int sum = 0;
        for (int i = 0; i < max; i++) {
            if (i%num1 == 0 || i%num2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        NaturalNumbersBelow1000 numbersBelow1000 = new NaturalNumbersBelow1000();

        int num1 = 3, num2 = 5, max = 1000;
        Logger.getLogger(NaturalNumbersBelow1000.class.getName())
                .log(Level.INFO, "Sum is = {0}", numbersBelow1000.numbersBelow1000(num1, num2, max));
    }
}