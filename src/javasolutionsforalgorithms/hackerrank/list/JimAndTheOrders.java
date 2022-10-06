package javasolutionsforalgorithms.hackerrank.list;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Jim's Burgers has a line of hungry customers.
 * Orders vary in the time it takes to prepare them.
 * Determine the order the customers receive their orders.
 * Start by numbering each of the customers from 1 to n, front of the line to the back.
 * You will then be given an order number and a preparation time for each customer.
 *
 * The time of delivery is calculated as the sum of the order number and the preparation time.
 * If two orders are delivered at the same time, assume they are delivered in ascending customer number order.
 *
 * For example, there are n = 5 customers in line.
 * They each receive an order number order[i] and a preparation time prep[i].:
 *
 * Customer	1	2	3	4	5
 * Order #		8	5	6	2	4
 * Prep time	3	6	2	3	3
 * Calculate:
 * Serve time	11	11	8	5	7
 * We see that the orders are delivered to customers in the following order:
 *
 * Order by:
 * Serve time	5	7	8	11	11
 * Customer	    4	5	3	1	2
 *
 * Function Description
 *
 * Complete the jimOrders function in the editor below.
 * It should return an array of integers that represent the order that customers' orders are delivered.
 */
public class JimAndTheOrders {

    public static List<Integer> jimOrders(List<List<Integer>> orders) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int counter = 1;
        for(List<Integer> order : orders) {
            int sum = order.get(0) + order.get(1);
            map.put(counter, sum);
            counter++;
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(a -> a.getKey())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<List<Integer>> data = new ArrayList<>();
        data.add(Arrays.asList(8, 3));
        data.add(Arrays.asList(4, 2));
        data.add(Arrays.asList(5, 6));
        data.add(Arrays.asList(3, 1));
        data.add(Arrays.asList(4, 3));

        System.out.println(JimAndTheOrders.jimOrders(data));
    }
}
