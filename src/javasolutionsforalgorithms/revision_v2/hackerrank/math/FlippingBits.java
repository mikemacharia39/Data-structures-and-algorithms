package javasolutionsforalgorithms.revision_v2.hackerrank.math;

/**
 * <a href="https://www.hackerrank.com/challenges/flipping-bits/problem">...</a>
 *
 * You will be given a list of 32 bit unsigned integers. Flip all the bits ( 1 -> 0 and 0 -> 1) and return the result as
 * an unsigned integer.
 */
public class FlippingBits {

    // Solution 1

    public static long flippingBits1(long n) {
        return n ^ ((1L << 32) - 1); // XOR with 32 bits of 1
    }

    // Solution 2

    public static long flippingBits(long n) {

        long[] bits = new long[32];

        String toBinary = longToBinary(n);

        int toBinaryLen = toBinary.length() - 1;
        for (int i = bits.length - 1; i >= (bits.length - toBinary.length()); i--) {
            bits[i] = toBinary.charAt(toBinaryLen) - '0';
            toBinaryLen--;
        }

        for (int j = bits.length - 1; j >= 0; j--) {
            long newBit = (bits[j] + 1) % 2;
            bits[j] = newBit;
        }

        return binaryToLong(bits);
    }

    private static long binaryToLong(long[] bits) {

        long sum = 0;
        for (long bit : bits) {
            sum = (2 * sum) + bit;
        }

        return sum;
    }

    private static String longToBinary(long n) {
        if (n <= 1) {
            return Long.toString(n);
        }

        return longToBinary(n/2) + n % 2;
    }
}
