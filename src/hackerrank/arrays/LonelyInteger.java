package hackerrank.arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of integers, where all elements but one occur twice, find the unique element.
 *
 * Example
 * a = {1,2,3,4,3,2,1}
 *
 * The unique element is 4.
 *
 * Function Description
 *
 * Complete the lonely integer function in the editor below.
 *
 * lonely integer has the following parameter(s):
 *
 * int a[n]: an array of integers
 *
 * Returns int: the element that occurs only once
 */
public class LonelyInteger {

    public static int lonelyInteger(List<Integer> a) {
        Set<Integer> set = new HashSet<>();
        a.forEach(num -> {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        });

        return set.iterator().next();
    }
}
