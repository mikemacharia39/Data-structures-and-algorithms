package javasolutionsforalgorithms.hackerrank.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of stick lengths, use 3 of them to construct a non-degenerate triangle with the maximum possible perimeter.
 * Return an array of the lengths of its sides as 3 integers in non-decreasing order.
 *
 * If there are several valid triangles having the maximum perimeter:
 *
 * Choose the one with the longest maximum side.
 * If more than one has that maximum, choose from them the one with the longest minimum side.
 * If more than one has that maximum as well, print any one them.
 * If no non-degenerate triangle exists, return [-1].
 * 
 *
 * Sample Input 0
 *
 * 1 1 1 3 3
 * Sample Output 0
 *
 * 1 3 3
 *
 * -------------------------------------------------------------------------------------------
 *
 * Non-degenerate triangle − it is a triangle that has a positive area.
 * The condition for a non-degenerate triangle with sides a, b, c is −
 *
 * a + b > c
 * a + c > b
 * b + c > a
 */
public class NonDegenerateTriangle {
    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        List<Integer> result = new ArrayList<>();
        sticks.sort(Integer::compare);
        for (int i = sticks.size()-1; i > 1; i--) {
            int sideA = sticks.get(i-2);
            int sideB = sticks.get(i-1);
            int sideC = sticks.get(i);
            if (sideA + sideB > sideC) {
                result.add(sideA);
                result.add(sideB);
                result.add(sideC);
                return result;
            }
        }
        result.add(-1);
        return result;
    }
}
