package codility;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array where the index represents days and values are locations, assuming Dave starts the visits,
 * when would it cost him less to do all visits
 *
 * Example 1: 1,7,3,2 are the locations
 * Dave can visit {1,7,3,7,2} or {7,3,7,2,1} or {3,7,2,1}
 * [0]=1
 * [1]=7
 * [2]=3
 * [3]=7
 * [4]=2
 * [5]=1
 * [6]=7
 *
 * {3,7,2,1} is the array when Dave was able to visit all locations at minimum cost
 *
 * {1,7,3,7,2,1,7}
 */
public class SmallestSubArrayAfterVisists {

    public int minVisits(int[] locations) {
        Set<Integer> set = new HashSet<>();
        for (int location : locations) {
            set.add(location);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < locations.length; i++) {
            Set<Integer> set2 = new HashSet<>();
            for (int j = i; j < locations.length; j++) {
                set2.add(locations[j]);
                if (set.equals(set2)) {
                    min = Math.min(min, j - i + 1);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        SmallestSubArrayAfterVisists visits = new SmallestSubArrayAfterVisists();

        int[] locations = {1,7,3,7,2,1,7};

        System.out.println(visits.minVisits(locations));
    }
}
