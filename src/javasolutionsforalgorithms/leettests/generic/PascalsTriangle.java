package javasolutionsforalgorithms.leettests.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/pascals-triangle/">...</a>
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> initList = List.of(1);
        result.add(initList);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = result.get(i-1);
            List<Integer> list = newRow(prev);
            result.add(list);
        }
        return result;
    }

    public List<Integer> newRow(List<Integer> prev) {
        int n = prev.size();
        List<Integer> ans = new ArrayList<>(prev);
        for (int i = 1; i < n; i++) {
            int sum = prev.get(i-1) + prev.get(i);
            ans.set(i,sum);
        }
        ans.add(1);
        return ans;
    }
}
