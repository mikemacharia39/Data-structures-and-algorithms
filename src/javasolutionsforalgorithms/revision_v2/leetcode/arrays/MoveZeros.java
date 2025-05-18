package javasolutionsforalgorithms.revision_v2.leetcode.arrays;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int currentNonZeroPos = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[currentNonZeroPos] = nums[i];
                currentNonZeroPos++;
            }
        }

        while (currentNonZeroPos < n) {
            nums[currentNonZeroPos] = 0;
            currentNonZeroPos++;
        }
    }
}
