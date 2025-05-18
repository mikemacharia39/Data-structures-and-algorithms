package javasolutionsforalgorithms.revision_v2.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }
        int startRange = 0;
        for (int i = 1; i <= nums.length; i++) {
            // check if it's the last element of if the sum of the previous + 1 equals the current
            if (i == nums.length || nums[i-1] + 1 != nums[i]) {
                if (nums[startRange] == nums[i-1]) {
                    result.add(Integer.toString(nums[startRange]));
                } else {
                    result.add(nums[startRange] + "->" + nums[i-1]);
                }
                startRange = i;
            }

        }
        return result;
    }
}
