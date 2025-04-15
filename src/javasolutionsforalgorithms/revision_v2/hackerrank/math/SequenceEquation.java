package javasolutionsforalgorithms.revision_v2.hackerrank.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/permutation-equation/problem">...</a>
 *
 * Given a sequence of n integers, p(1), p(2),...,p(n) where each element is distinct and satisfies 1 <= p(x) <= n.
 * For each x where 1 <= x <= n, that is x increments from 1 to n, find any integer y such that p(p(y))
 * and keep a history of the values of y in a return array.
 */
public class SequenceEquation {

    /**
     * The function permutationEquation has a time complexity of O(n^2) because it uses the indexOf method
     * Space complexity is O(n) because of the newPositions list.
     * @param p
     * @return
     */
    public static List<Integer> permutationEquation(List<Integer> p) {
        // the index represents the positions
        int[] arrayOrder = new int[p.size()];
        // assign the values based on the position of the index value in p
        for (int i = 0; i < p.size(); i++) {
            arrayOrder[i] = p.indexOf(i+1)+1;
        }
        System.out.println(Arrays.toString(arrayOrder));
        // The next one find the position of p.get(arrayOrder[i]);, in the original list p
        List<Integer> newPositions = new ArrayList<>();
        for (int j : arrayOrder) {
            newPositions.add(p.indexOf(j) + 1);
        }

        return newPositions;
    }
}
