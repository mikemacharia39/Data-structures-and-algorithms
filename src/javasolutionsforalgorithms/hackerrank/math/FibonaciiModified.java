package javasolutionsforalgorithms.hackerrank.math;

import java.math.BigInteger;

/**
 * ti+2 = ti + (ti+1)^2
 */
public class FibonaciiModified {

    public static BigInteger fibonacciModified(BigInteger t1, BigInteger t2, int n) {

        int i = 0;
        BigInteger sum;
        while (i < n-2) {
            sum = t1.add(square(t2));
            t1 = t2;
            t2 = sum;
            i++;
        }

        return t2;
    }

    private static BigInteger square(BigInteger num) {
        return num.multiply(num);
    }
}
