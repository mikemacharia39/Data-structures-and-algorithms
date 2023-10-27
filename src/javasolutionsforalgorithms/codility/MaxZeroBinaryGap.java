package javasolutionsforalgorithms.codility;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at
 * both ends in the binary representation of N.
 * <p>
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
 * The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
 * The number 20 has binary representation 10100 and contains one binary gap of length 1.
 * The number 15 has binary representation 1111 and has no binary gaps.
 * The number 32 has binary representation 100000 and has no binary gaps.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int N); }
 * <p>
 * that, given a positive integer N, returns the length of its longest binary gap.
 * The function should return 0 if N doesn't contain a binary gap.
 * <p>
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its
 * longest binary gap is of length 5. Given N = 32 the function should return 0,
 * because N has binary representation '100000' and thus no binary gaps.
 */
public class MaxZeroBinaryGap {

    public int solution(int N) {
        int max = 0;

        int count = 1;
        String bString = binaryString(N);
        for (int i = 0; i < bString.length(); i++) {

            if (i + 1 < bString.length() && bString.charAt(i) == '0') {
                if (bString.charAt(i) == bString.charAt(i + 1)) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
        }

        return max;
    }

    /**
     * You generate a binary by dividing the initial value by 2 and getting the remainder
     * Generating a binaryString
     * @param N integer
     * @return binaryString
     */
    private String binaryString(int N) {
        if (N <= 1) {
            return String.valueOf(N);
        }
        return binaryString(N / 2) + N % 2;
    }

}
