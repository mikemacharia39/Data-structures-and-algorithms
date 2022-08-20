package javasolutionsforalgorithms.projecteuler.numbers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://projecteuler.net/problem=5
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * 2520{10*9*4*7}
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class SmallestEvenlyDivisibleNumber {

    /**
     * 1. loop through the numbers
     * 2. Check if the current max number is divisible by the numbers
     * 3. if not divisible check the number causing it not to be divible then use that value to
     *    multiply the current max number
     *
     *
     * @param min range 0
     * @param max range > min
     * @return smallest divisible number
     */
    public int smallestDivisibleNum(int min, int max) {

        if (max <= min && max <= 1) {
            return min * max;
        }

        int maxNumber = max;

        for (int i = max; i >= min; i--) {
            if (maxNumber%i != 0) {
                maxNumber *= smallestNextVal(maxNumber, i);
            }
        }

        return maxNumber;
    }

    /**
     * This function determines if the current value i.e. multiplication of nums is divisible by next nums
     * in list
     * @param maxVal  the current multiplied value
     * @param nextNum the next value in the list
     * @return smallest value
     */
    private int smallestNextVal(int maxVal, int nextNum) {

        if (nextNum >= maxVal) {
            return 1;
        }

        int divisor = 1;
        for (int i = nextNum; i >= 1; i--) {
            if (maxVal%i == 0 && nextNum%i == 0) {
                divisor = nextNum/i;
                break;
            }
        }
        return divisor;
    }

    public static void main(String[] args) {
        SmallestEvenlyDivisibleNumber evenlyDivisibleNumber = new SmallestEvenlyDivisibleNumber();

        int min = 1;
        int max = 20;

        Logger.getLogger(SmallestEvenlyDivisibleNumber.class.getName())
                .log(Level.INFO, "Smallest Evenly Divisible: {0}",
                        evenlyDivisibleNumber.smallestDivisibleNum(min, max));
    }
    
}
