package hackerrank.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Two friends like to pool their money and go to the ice cream parlor. They always choose two distinct flavors and they spend all of their money.
 *
 * Given a list of prices for the flavors of ice cream, select the two that will cost all of the money they have.
 *
 * Example m = 6, cost = {1,3,4,5,6}
 *
 * The two flavors that cost 1 and 5 meet the criteria. Using 1-based indexing, they are at indices 1 and 4.
 */
public class IceCreamParlor {
    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if (arr.get(i) + arr.get(j) == m) {
                    list.add(i+1);
                    list.add(j+1);
                }
            }
        }

        return list;
    }

}
