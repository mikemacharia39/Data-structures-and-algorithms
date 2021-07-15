package leetTests;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElementFromArray {

    public static void main(String[] args) {

        //int[] nums = {3,2,2,3}; int val = 3;
        //Output: 2, nums = [2,2]

        int[] nums = {0,1,2,2,3,0,4,2}; int val = 2;
        //Output: 5, nums = [0,1,4,0,3]

        RemoveElementFromArray removeElementFromArray = new RemoveElementFromArray();

        System.out.println(removeElementFromArray.removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {

        if (nums.length == 0) {return 0;};

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
