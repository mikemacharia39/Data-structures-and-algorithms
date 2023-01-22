package javasolutionsforalgorithms.hackerrank.stack;

import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/largest-rectangle/problem">...</a>
 * Complete the function largestRectangle int the editor below. It should return an integer representing the largest
 * rectangle that can be formed within the bounds of consecutive buildings.
 */
public class LargestRectangle {

    /**
     * Solution without using stack. IT WORKS THOUGH
     * @param h list of building heights
     * @return largest rectangle
     */
    public static long largestRectangle(List<Integer> h) {
        long maximum = Long.MIN_VALUE;

        for (int i = 0; i < h.size(); i++) {
            long currBuilding = h.get(i);
            long sum;
            long countBuilding = 0L;

            for (int j = i; j < h.size(); j++) {  // check right side of curr building
                if (h.get(j) >= currBuilding) {
                    countBuilding++;
                } else {
                    break;
                }
            }

            for (int j = i - 1; j >= 0; j--) {  // check left side of curr building
                if (h.get(j) >= currBuilding) {
                    countBuilding++;
                } else {
                    break;
                }
            }
            sum = countBuilding * currBuilding;

            if (sum >= maximum) {
                maximum = sum;
            }
        }

        return maximum;
    }
}
