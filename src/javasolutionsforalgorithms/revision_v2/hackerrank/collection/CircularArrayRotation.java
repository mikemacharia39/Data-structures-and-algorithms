package javasolutionsforalgorithms.revision_v2.hackerrank.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/circular-array-rotation/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign">...</a>
 *
 * John Watson knows of an operation called a right circular rotation on an array of integers.
 * One rotation operation moves the last array element to the first position and shifts all remaining elements right one.
 * To test Sherlock's abilities, Watson provides Sherlock with an array of integers.
 * Sherlock is to perform the rotation operation a number of times then determine the value of the element at a given position.
 *
 * For each array, perform a number of right circular rotations and return the values of the elements at the given indices.
 */
public class CircularArrayRotation {

    /**
     * Time complexity = O(n)
     * Explanation: The logic is to get the new index after the rotation and then get the element at that index
     * @param a
     * @param k
     * @param queries
     * @return
     */
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        int n = a.size();
        k = k % n;
        for (int i = 0; i < queries.size(); i++) {
            int index = queries.get(i);
            queries.set(i, a.get((n - k + index) % n)); // (n - k + index) % n is the new index after rotation
        }
        return queries;
    }

    public static List<Integer> circularArrayRotation1(List<Integer> a, int k, List<Integer> queries) {
        int n = a.size();
        k = k % n; // if k is greater than n, then k = k % n, else k = k. This is to avoid unnecessary rotations
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(a.get(n - k + i)); // add the elements from the end of the list to the beginning
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            ans.add(result.get(queries.get(i))); // get the elements from the result list
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(circularArrayRotation(List.of(1, 2, 3), 2, List.of(0, 1, 2))); // [2, 3, 1]
        System.out.println(circularArrayRotation(List.of(1, 2, 3), 3, List.of(0, 1, 2))); // [1, 2, 3]
        System.out.println(circularArrayRotation(List.of(1, 2, 3), 4, List.of(0, 1, 2))); // [3, 1, 2]
        System.out.println(circularArrayRotation(List.of(1, 2, 3), 5, List.of(0, 1, 2))); // [2, 3, 1]
    }
}
