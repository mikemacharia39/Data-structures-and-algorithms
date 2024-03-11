package javasolutionsforalgorithms.revision_v2.hackerrank.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * There are a number of plants in a garden. Each of the plants has been treated with some amount of pesticide.
 * After each day, if any plant has more pesticide than the plant on its left, being weaker than the left one, it dies.
 *
 * You are given the initial values of the pesticide in each of the plants.
 * Determine the number of days after which no plant dies, i.e. the time after which there is no plant with more pesticide
 * content than the plant to its left.
 *
 * This example provided is 1-based indexing
 *
 * Example:
 * p = {3, 6, 2, 7, 5}
 * answer = 2, day 1 plants 2 and 4 die and day 2 plant 5 dies.
 */
public class PoisonousPlants {

    private static int days = 0;
    public static int poisonousPlants(List<Integer> p) {
        helper(p);
        return days;
    }

    private static void helper(List<Integer> ans) {
        List<Integer> positions = new ArrayList<>();
        // 6 5 8 4 7 10 9
        for (int i = 0; i < ans.size()-1; i++) {
            if (ans.get(i) < ans.get(i+1)) {
                positions.add(i+1);
            }
        }
        System.out.println("Plants = " + ans + " | days = " + days);
        if (positions.isEmpty()) {
            return;
        }

        days += 1;
        List<Integer> result = new ArrayList<>(removeElements(ans, positions));

        positions.clear();

        helper(result);
    }

    private static List<Integer> removeElements(List<Integer> ans, List<Integer> positions) {

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        for (Integer position : positions) {
            result[position] = Integer.MIN_VALUE;
        }

        List<Integer> finalResult = new LinkedList<>();

        for (int j : result) {
            if (j != Integer.MIN_VALUE) {
                finalResult.add(j);
            }
        }
        return finalResult;
    }

    public static void main(String[] args) {
        List<Integer> p = List.of(6, 5, 8, 4, 7, 10, 9); // 2

        System.out.println(poisonousPlants(p));
    }
}
