package leetTests;

public class TwoSum {

    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] vals = twoSum.twoSum(nums, target);

        System.out.println();
    }

    public int[] twoSum(int[] nums, int target) {

        int numsSize = nums.length;
        int[] output = new int[2];
        for (int i = 0; i < numsSize; i++) {
            if ((nums[i] + nums[i+1]) == target) {
                output[0] = i;
                output[1] = i+1;
                System.out.println("Output1: " + output[0] +" Output2: "+ output[1]);
                break;
            }
        }
        return output;
    }
}
