package leettests.math;

import java.util.Arrays;

/**
 * Example 1:
 * num1: [9,2,3]  num2: [3,5,6]
 *
 * 9%10 = 9
 * 18%10= 8
 *
 * [4,7,9]
 *
 * Example 2:
 * num1: [9]  num2: [3,5,6]
 * [3,6,5]
 */
public class SumNumsInArray {

    /**
     *
     * Time Complexity O(m+n)
     *
     * carry
     * [9]  [1]    [0]
     *
     * [1,0]
     *
     * @param num1
     * @param num2
     * @return
     */

    public int[] sum(int[] num1, int[] num2) {

        int nlen = num1.length;
        int mlen = num2.length;
        int len = Math.max(nlen, mlen);

        int[] ans = new int[len];

        int i = nlen - 1;
        int j = mlen - 1;
        int k = len - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0) {
                sum += num1[i];
            }

            if (j >= 0) {
                sum += num2[j];
            }

            sum += carry;
            ans[k] = sum%10;
            carry = sum/10;

            k--;
            i--;
            j--;
        }

        if (carry > 0) {
            int[] ans2 = new int[len+1];

            ans2[0] = carry;
            int y = 1;
            for (int z = 0; z < ans.length; z++) {
                ans2[y++] = ans[z];
            }
            return ans2;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] num1 = {9,2,3};
//        int[] num2 = {3,5,6};

        int[] num1 = {1};
        int[] num2 = {};

        SumNumsInArray sumNumsInArray = new SumNumsInArray();

        System.out.println(Arrays.toString(sumNumsInArray.sum(num1, num2)));
    }
}
