package javasolutionsforalgorithms.leettests;

import java.util.HashSet;
import java.util.Set;

public class OneRepeatedNumber {

    public static void main(String[] args) {
        OneRepeatedNumber oneRepeatedNumber = new OneRepeatedNumber();

        int[] nums = {2, 8, 9, 1, 3, 0};

        System.out.println(oneRepeatedNumber.solution(nums));
    }

    public int solution(int[] nums) {
        Set<Integer> mSets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!mSets.add(nums[i])) {
                return nums[i];
            }
        }

        return 0;
    }

    public int solution2(int[] nums) {
        for (int j : nums) {
            int countDuplicate = 0;
            for (int num : nums) {
                if (j == num) {
                    countDuplicate++;
                }
            }
            if (countDuplicate == 2) {
                return j;
            }
        }

        return 0;
    }
}
