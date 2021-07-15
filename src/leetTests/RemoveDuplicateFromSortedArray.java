package leetTests;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {

        int[] nums = {1,1,2};
        //Output: 2, nums = [1,2]

        //int[] nums = {0,0,1,1,1,2,2,3,3,4};
        //Output: 5, nums = [0,1,2,3,4]

        RemoveDuplicateFromSortedArray duplicateFromSortedArray = new RemoveDuplicateFromSortedArray();

        System.out.println(duplicateFromSortedArray.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
