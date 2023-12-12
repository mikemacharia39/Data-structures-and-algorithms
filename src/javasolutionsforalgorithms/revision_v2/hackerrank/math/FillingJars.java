package javasolutionsforalgorithms.revision_v2.hackerrank.math;

import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/filling-jars/problem">...</a>
 *
 * Animesh has n empty candy jars, numbered from 1 to n, with infinite capacity.
 * He performs m operations. Each operation is described by  integers, a, b, and k.
 * Here, a and b are indices of the jars, and k is the number of candies to be added inside each jar whose index lies
 * between a and b (both inclusive). Can you tell the average number of candies after m operations?
 *
 */
public class FillingJars {

    /**
     * Time complexity: O(n)
     * @param n
     * @param operations
     * @return
     */
    public static int solve(int n, List<List<Integer>> operations) {
        double sum = 0;
        double times = 0;
        double average = 0;
        for (List<Integer> operation : operations) {
            int a = operation.get(0);
            int b = operation.get(1);
            int k = operation.get(2);
            times = b - a + 1;
            sum = k * times;
            average += sum / n;
        }

        return (int)average;
    }

    /**
     * Time complexity: O(n*m)
     * Easy to understand but times out for large inputs
     * @param n
     * @param operations
     * @return
     */
    public static int solve1(int n, List<List<Integer>> operations) {
        int[] result = new int[n+1];

        for (List<Integer> list : operations) {
            for (int i = list.get(0); i <= list.get(1); i++) {
                result[i] += list.get(2);
            }
        }

        int sum = 0;
        for (int number : result) {
            sum += number;
        }
        return sum/n;
    }
}
