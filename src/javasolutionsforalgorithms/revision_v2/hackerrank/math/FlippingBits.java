package javasolutionsforalgorithms.revision_v2.hackerrank.math;

/**
 * <a href="https://www.hackerrank.com/challenges/flipping-bits/problem">...</a>
 *
 * You will be given a list of 32 bit unsigned integers. Flip all the bits ( 1 -> 0 and 0 -> 1) and return the result as
 * an unsigned integer.
 */
public class FlippingBits {

    public static long flippingBits(long n) {
        return n ^ ((1L << 32) - 1); // XOR with 32 bits of 1
    }
}
