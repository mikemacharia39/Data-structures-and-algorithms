package javasolutionsforalgorithms.revision_v2.hackerrank.math;

import java.util.Comparator;
import java.util.List;

/**
 * Marc loves cupcakes, but he also likes to stay fit. Each cupcake has a calorie count,
 * and Marc can walk a distance to expend those calories.
 * If Marc has eaten  cupcakes so far, after eating a cupcake with c calories he must walk at least 2^j * c miles to maintain his weight.
 *
 * Example:
 * calories = [5, 10, 7]
 * answer = 44, because the minimum miles he must walk is 2^0 * 10 + 2^1 * 7 + 2^2 * 5 = 44
 */
public class MarcsCakewalk {
    public static long marcsCakewalk(List<Integer> calorie) {
        calorie.sort(Comparator.reverseOrder());
        long sum = 0;
        for (int i = 0; i < calorie.size(); i++) {
            sum += (long) (Math.pow(2,i) * calorie.get(i));
        }

        return sum;
    }
}
