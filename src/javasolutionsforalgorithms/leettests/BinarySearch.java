package javasolutionsforalgorithms.leettests;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        int[] nums = {-1,0,3,5,9,12}; int target = 9;
        //Output: 4
        //Explanation: 9 exists in nums and its index is 4

        System.out.println("Index is: " +binarySearch.search(nums, target));
    }

    public int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length;

        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;

            if (nums[mid] == target) {
                return mid;
            }

            // if target is lesser that the mid number then reduce the hi - 1 <<
            if (target < nums[mid]) {
                hi = mid - 1;
            } else { // if the target is greater then move the lo + 1 >>
                lo = mid + 1;
            }
        }
        return -1;
    }
}
