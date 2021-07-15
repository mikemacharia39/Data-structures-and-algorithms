package leetTests.arrayandstrings;

/**
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
 *
 * For example, in array A such that:
 *
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * the function should return 7, as explained in the example above.
 */

import java.util.HashSet;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        OddOccurrencesInArray occurrencesInArray = new OddOccurrencesInArray();

        int[] A = {9, 3, 9, 3, 9, 7, 9};

        System.out.println("Odd Occurrence: " + occurrencesInArray.solution(A));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8

        HashSet<Integer> set = new HashSet<>();

        for (int j : A) {
            if (!set.contains(j)) {
                set.add(j);
            } else {
                set.remove(j);
            }
        }

        return set.isEmpty() ? 0 : set.iterator().next();
    }
}
