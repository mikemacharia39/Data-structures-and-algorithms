package javasolutionsforalgorithms.hackerrank.list;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/beautiful-pairs/problem">...</a>
 *
 * Function Description
 *
 * Complete the beautifulPairs function in the editor below.
 * It should return an integer that represents the maximum number of pairwise disjoint beautiful pairs that can be formed.
 *
 * BeautifulPairs has the following parameters:
 * A: an array of integers
 * B: an array of integers
 *
 * N/B: Your task is to change exactly 1 element in B so that the size of the pairwise disjoint beautiful set is maximum.
 */
public class BeautifulPairs {
    public static int beautifulPairs(List<Integer> A, List<Integer> B) {
        // both list A and B are of equal size
        // create temp list to hold elements of either Array
        List<Integer> temp = new ArrayList<>(A);

        int n = temp.size();

        int countDisjoint = 0;

        for (Integer num : temp) {
            if (A.contains(num) && B.contains(num)) {
                countDisjoint++;

                A.remove(num);
                B.remove(num);
            }
        }

        // Your task is to change exactly 1 element in B so that the size of
        // the pairwise disjoint beautiful set is maximum.
        if (A.size() >= 1 && B.size() >= 1) {
            countDisjoint++;
        } else if (n == countDisjoint) {
            // why do we have this here?
            // Because "Your task is to change exactly 1 element",

            // if all elements matched then you change 1 element, then the
            // countDisjoint decreases
            countDisjoint--;
        }

        return countDisjoint;
    }
}
