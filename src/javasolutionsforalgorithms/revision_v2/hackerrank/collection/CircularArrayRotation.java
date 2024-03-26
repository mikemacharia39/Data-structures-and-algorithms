package javasolutionsforalgorithms.revision_v2.hackerrank.collection;

import java.util.List;

/**
 * John Watson knows of an operation called a right circular rotation on an array of integers.
 * One rotation operation moves the last array element to the first position and shifts all remaining elements right one.
 * To test Sherlock's abilities, Watson provides Sherlock with an array of integers.
 * Sherlock is to perform the rotation operation a number of times then determine the value of the element at a given position.
 *
 * For each array, perform a number of right circular rotations and return the values of the elements at the given indices.
 */
public class CircularArrayRotation {

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        int n = a.size();
        k = k % n;
        for (int i = 0; i < queries.size(); i++) {
            int index = queries.get(i);
            queries.set(i, a.get((n - k + index) % n)); // (n - k + index) % n is the new index after rotation
        }
        return queries;
    }
}
