package javasolutionsforalgorithms.hackerrank.arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/two-arrays/problem">...</a>
 *
 */
public class PermutingTwoArrays {

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {

        Collections.sort(A);
        B.sort(Comparator.reverseOrder());

        for (int i = 0; i < A.size(); i++) {
            if ((A.get(i) + B.get(i)) < k) {
                return "NO";
            }
        }

        return "YES";
    }
}
