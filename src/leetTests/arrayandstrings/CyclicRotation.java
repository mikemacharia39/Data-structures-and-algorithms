package leetTests.arrayandstrings;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right
 * by one index, and the last element of the array is moved to the first place.
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
 * (elements are shifted right by one index and 6 is moved to the first place).
 *
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(int[] A, int K); }
 *
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 *
 * For example, given
 *
 *     A = [3, 8, 9, 7, 6]
 *     K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 *
 *     [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 *
 *     [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 *
 *     [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * For another example, given
 *
 *     A = [0, 0, 0]
 *     K = 1
 */
public class CyclicRotation {

    public static void main(String[] args) {

        CyclicRotation rotation = new CyclicRotation();

        int[] array = {};

        System.out.println("Original: " + Arrays.toString(array));

        int shift = 3;

        System.out.println("Ans: " + Arrays.toString(rotation.solution(array, shift)));

    }

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        if (K == 0 || A.length == 0) {
            return A;
        }


        int arrLen = A.length;

        for (int i = 0; i < K; i++) {
            int last = A[arrLen-1];

            // This single line can replace the for loop
            //System.arraycopy(A, 0, A, 1, arrLen - 1);

            for (int j = arrLen - 1; j > 0; j--) {
                A[j] = A[j-1];
            }
            A[0] = last;
        }

        return A;
    }
}

