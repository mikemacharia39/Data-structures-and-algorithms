package javasolutionsforalgorithms.revision_v2.hackerrank.math;

import java.util.Comparator;
import java.util.List;

/**
 * A video player plays a game in which the character competes in a hurdle race.
 * Hurdles are of varying heights, and the characters have a maximum height they can jump.
 * There is a magic potion they can take that will increase their maximum jump height by  unit for each dose.
 * How many doses of the potion must the character take to be able to jump all of the hurdles.
 * If the character can already clear all of the hurdles, return 0.
 *
 * Example:
 * arr = [1, 2, 3, 3, 2]
 * k = 1
 *
 * Answer = 2, the highest hurdle is 3 and the character can jump 1 unit, so the character needs to take 2 doses of the potion
 */
public class TheHurdleRace {
    public static int hurdleRace(int k, List<Integer> height) {

        int maxHeight = height.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);

        return maxHeight <= k ? 0 : maxHeight - k;
    }
}
