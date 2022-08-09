package hackerrank.arrays;

import java.util.ArrayList;
import java.util.HashMap;
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

    /**
     * Time complexity is O(n)
     * space complexity is 0(n) due to HashMap - we have not introduced new memory, List<Integer> list is expected
     * @param m sum
     * @param arr list
     * @return list
     */
    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (map.containsKey(m - arr.get(i))) {
                list.add(map.get(m - arr.get(i))+1);
                list.add(i+1);
            }
            map.put(arr.get(i), i);
        }
        return list;
    }

    /**
     * Time complexity is O(n^2)
     * space complexity is 0(1) - we have not introduced new memory, List<Integer> list is expected
     * @param m sum
     * @param arr list
     * @return list
     */
    public static List<Integer> icecreamParlor1(int m, List<Integer> arr) {
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

    public static void main(String[] args) {
        IceCreamParlor iceCreamParlor = new IceCreamParlor();

        //List<Integer> list = Arrays.asList(1,3,4,5,6);
        List<Integer> list = List.of(1,3,4,5,6);

        System.out.println(IceCreamParlor.icecreamParlor(6, list));
    }
}
