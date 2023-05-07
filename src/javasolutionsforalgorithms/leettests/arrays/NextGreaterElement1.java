package javasolutionsforalgorithms.leettests.arrays;

public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) {
            ans[i] = checkIfNextValue(nums1[i], nums2);
        }

        return ans;
    }

    private static int checkIfNextValue(int val, int[] nums2) {
        int count = 1;
        for(int i = 0; i < nums2.length; i++) {
            if (val == nums2[i]) {
                while (nums2.length > i+count) {
                    if (nums2[i+count] > val) {
                        return nums2[i+count];
                    }
                    count++;
                }
            }
        }
        return -1;
    }
}
