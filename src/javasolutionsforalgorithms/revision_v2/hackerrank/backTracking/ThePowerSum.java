package javasolutionsforalgorithms.revision_v2.hackerrank.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/the-power-sum/problem">...</a>
 *
 * Find the number of ways that a given integer, X, can be expressed as the sum of the Nth powers of unique, natural numbers.
 *
 * For example, if X=13 and n=2, we have to find all combinations of unique squares adding up to 13. The only solution is 2^2 + 3^2.
 *
 * Function Description
 *
 * Complete the powerSum function in the editor below.
 * It should return an integer that represents the number of possible combinations.
 *
 * PowerSum has the following parameter(s):
 *
 * X: the integer to sum to
 * N: the integer power to raise numbers to
 */
public class ThePowerSum {

    public static int powerSum(int X, int N) {
        List<Integer> ans = new ArrayList<>();

        helper(X, 0, 1, N, ans);

        return ans.size();
    }

    private static void helper(int x, int sum, int start, int n, List<Integer> ans) {

        if (x == sum) {
            ans.add(1);
            return;
        }

        if (sum > x) return;

        for (int i = start; i*i <= x; i++) {
            int anotherVal = (int)Math.pow(i,n);
            helper(x, sum + anotherVal, i + 1, n, ans);
        }
    }

}
