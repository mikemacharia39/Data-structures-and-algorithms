package javasolutionsforalgorithms.revision_v2.hackerrank.manipulation;

/**
 * <a href="https://www.hackerrank.com/challenges/maximizing-xor/problem">...</a>
 *
 * Given two integers, l and r, find the maximal value of a xor b, where a and b satisfy the following condition:
 * l <= a <= b <= r
 * For example if l = 11 and r = 12, then,
 *
 * 11 xor 11 = 0
 * 11 xor 12 = 7
 * 12 xor 12 = 0
 *
 * Our maximum value is 7
 */
public class MaximizingXOR {

    /**
     * The logic is to find the xor of all the numbers between l and r and then find the maximum xor
     *
     * The XOR operator is ^ in Java. It is used to compare two binary numbers. If the bits are different, it returns 1, else 0.
     *
     * Time complexity = O(N^2)
     * @param l
     * @param r
     * @return
     */
    public static int maximizingXor(int l, int r) {
        int max =0;
        for(int i = l; i<=r; i++){
            for(int j=l; j<=r; j++){
                int result = i^j; // ^ is the xor operator
                max=Math.max(result, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximizingXor(11, 12));
    }
}
