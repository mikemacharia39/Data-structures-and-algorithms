package javasolutionsforalgorithms.leettests.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/">...</a>
 *
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 *
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Example 2:
 *
 * Input: rowIndex = 0
 * Output: [1]
 *
 * Example 3:
 *
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 * 0 <= rowIndex <= 33
 *
 *
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        // 1,1
        // 1,2,1
        // 1,3,3,1
        // 1,4,6,4,1

        // Initialize the list at position 0 with 1
        // always append 1 at the end of the loop
        // the sum = j-1+j i.e. prev pos + cur pos

        List<Integer> ans = new ArrayList<>();
        ans.add(1); // initialize position 0 to start with 1
        for (int i = 1; i <= rowIndex; i++) {  // rowIndex is <= because at every position it is the pos+1
            for (int j = i-1; j >= 1; j--) {
                ans.set(j, ans.get(j) + ans.get(j-1)); // add values in reverse, this is important as you don't lose the initial/parent values
            }

            ans.add(1); // append 1 at the end after each loop
        }


        return ans;
    }
}
