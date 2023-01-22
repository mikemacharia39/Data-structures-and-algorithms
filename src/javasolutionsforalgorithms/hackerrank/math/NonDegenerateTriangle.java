package javasolutionsforalgorithms.hackerrank.math;

import java.util.ArrayList;
import java.util.List;

/**
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
