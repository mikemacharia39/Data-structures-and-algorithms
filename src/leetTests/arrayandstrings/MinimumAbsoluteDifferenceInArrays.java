package leetTests.arrayandstrings;

import java.util.Arrays;

/**
 * Minimum absolute difference between elements in 2 arrays and return the 2 values
 */
public class MinimumAbsoluteDifferenceInArrays {

    public static void main(String[] args) {
        
        int[] a = {23, 36, 2, 5, 11};
        int[] b = {4, 7, 20, 45};

        MinimumAbsoluteDifferenceInArrays diff = new MinimumAbsoluteDifferenceInArrays();

        System.out.println("Arrays: " + Arrays.toString(diff.solution(a, b)));
    }

    /**
     * Use Sorting along with the two-pointer sliding window approach
     * You can improve upon the brute force solution by first sorting the array and
     * then using the two-pointer sliding window pattern.
     *
     * Here is how it will work in this case:
     *
     * Initialize a variable to keep track of the smallest difference found so far (smallestDiff).
     * Sort both the arrays
     * Initialize two indexes (one for each array): i = 0 and j = 0.
     * Loop until we reach the end of any of the arrays.
     * For every iteration:
     * Compare the smallestDiff with abs(a1[i] - a2[j]) and reset it if the new difference is smaller.
     * If a1[i] < a2[j], increment i.
     * Otherwise, increment j
     *
     * Time complexity: O(mlog(m) + nlog(n) + n) = O(nlog(n))
     *
     * @param a array 1
     * @param b array 2
     * @return result
     */
    private int[] solution(int[] a, int[] b) {

        int[] ans = new int[2];
        int minVal = Integer.MAX_VALUE;

        int i = 0, j = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        while (i < a.length && j < b.length) {
            if (Math.abs(a[i] - b[j]) < minVal) {
                minVal = Math.abs(a[i] - b[j]);
                ans[0] = a[i];
                ans[1] = b[j];
            }

            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }

        }

        return ans;
    }

    /**
     * Brute Force approach: Use two for loops
     * The naive way to solve this problem is to use two for loops and compare the difference
     * of every pair to find the pair with the smallest difference:
     * Time complexity: O(n^2)
     *
     * @param a array 1
     * @param b array 2
     * @return answer
     */
    private int[] solution1(int[] a, int[] b) {
        
        int[] ans = new int[2];
        int minVal = Integer.MAX_VALUE;
        for (int j : a) {
            for (int k : b) {
                int difference = j - k;
                difference = Math.abs(difference);
                if (difference < minVal) {
                    minVal = difference;
                    ans[0] = j;
                    ans[1] = k;
                }
            }
        }

        return ans;
    }
}
