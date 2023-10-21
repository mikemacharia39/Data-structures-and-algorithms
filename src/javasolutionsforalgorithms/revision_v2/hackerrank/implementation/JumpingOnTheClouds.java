package javasolutionsforalgorithms.revision_v2.hackerrank.implementation;

import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign">...</a>
 * There is a new mobile game that starts with consecutively numbered clouds.
 * Some of the clouds are thunderheads and others are cumulus.
 * The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2.
 * The player must avoid the thunderheads. Determine the minimum number of jumps it will take to jump from the starting
 * position to the last cloud. It is always possible to win the game.
 *
 * For each game, you will get an array of clouds numbered  if they are safe or 1 if they must be avoided.
 *
 * Sample Input 0
 *
 * 0 0 1 0 0 1 0
 * Sample Output 0
 *
 * Result = 4
 * Explanation: 0 -> 2 -> 4 -> 6
 */
public class JumpingOnTheClouds {

    public static int jumpingOnClouds(List<Integer> c) {
        int totalJumps = 0;
        int i = 0;
        while (i < c.size() - 1) { // we don't need to jump on the last cloud
            if (i + 2 < c.size()) {// we can jump 2 clouds
                if (c.get(i + 2) == 0) {
                    i = i + 2;
                } else {
                    i++;
                }
            } else {
                i++;
            }
            totalJumps++;
        }
        return totalJumps;
    }
}
