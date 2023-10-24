package javasolutionsforalgorithms.revision_v2.hackerrank.implementation;

public class ArrayPivot {

    public static int pivotIndex(int[] nums) {
        int pivotIndex = 0;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            int rightSum = sum(nums, i, nums.length);
            if (leftSum == rightSum) {
                pivotIndex = i;
                break;
            }
        }
        return pivotIndex;
    }

    private static int sum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }
}
