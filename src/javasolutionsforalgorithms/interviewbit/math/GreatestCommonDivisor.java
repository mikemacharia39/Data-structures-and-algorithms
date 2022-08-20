package javasolutionsforalgorithms.interviewbit.math;

/**
 * <a href="https://www.interviewbit.com/problems/greatest-common-divisor/">...</a>
 *
 * Given 2 non-negative integers m and n, find gcd(m, n)
 *
 * GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
 *
 * Both m and n fit in a 32 bit signed integer.
 *
 * Example
 *
 * m : 6
 * n : 9
 */
public class GreatestCommonDivisor {

    /**
     * The Euclidean Algorithm
     * <a href="https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm">...</a>
     * @param A val 1
     * @param B val 2
     * @return GCD
     */
    public int gcd(int A, int B) {
        int l = Math.min(A, B);

        if (l == 0) {
            return Math.max(A, B);
        }

        if (l < 2 ) {
            return 1;
        }

        int diff = Math.abs(A - B);

        if (diff == 0) {
            return A;
        }

        for (int i = diff; i > 1; i--) {
            if (A%i == 0 && B%i == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * GCD
     * @param A val 1
     * @param B val 2
     * @return GCD
     */
    public int gcdSln(int A, int B) {
        int l = lesser(A, B);

        if (l == 0) {
            return Math.max(A, B);
        }

        if (l < 2 ) {
            return 1;
        }

        for (int i = l; i > 1; i--) {
            if (A%i == 0 && B%i == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * The smaller of the two
     * @param A val 1
     * @param B val 2
     * @return smaller of A and B
     */
    private int lesser(int A, int B) {
        return Math.min(A, B);
    }
}
