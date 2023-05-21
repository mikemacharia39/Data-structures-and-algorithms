package javasolutionsforalgorithms.leettests.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 * The array-form of an integer num is an array representing its digits in left to right order.
 *
 * For example, for num = 1321, the array form is [1,3,2,1].
 * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
 *
 * Example 1:
 *
 * Input: num = [1,2,0,0], k = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * Example 2:
 *
 * Input: num = [2,7,4], k = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 */
public class AddToArrayFormInteger {

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int len = num.length - 1;

        while (len >= 0 || k != 0) {
            if (len >= 0) {
                k += num[len--];
            }
            result.add(0, k % 10);
            k /= 10;
        }

        return result;
    }

    public List<Integer> addToArrayFormSolution3(int[] num, int k) {
        int kCopy = k;
        int digitsInK = 0;
        while (kCopy > 0) {
            kCopy /= 10;
            digitsInK++;
        }

        int[] kArr = new int[digitsInK];
        int i = digitsInK;
        for (int j = 0; j < digitsInK; j++) {
            kArr[--i] = k % 10;
            k /= 10;
        }

        List<Integer> ans = new ArrayList<>();

        int carry = 0;

        int x = num.length - 1;
        int y = kArr.length - 1;

        while (x >= 0 || y >= 0) {
            if (x >= 0) {
                carry += num[x--];
            }
            if (y >= 0) {
                carry += kArr[y--];
            }
            ans.add(0, carry % 10);
            carry = carry / 10;
        }

        if (carry > 0) {
            ans.add(0, carry);
        }

        return ans;
    }


    public List<Integer> addToArrayFormSln2(int[] num, int k) {
        int numArrToInt = 0;
        for (int j : num) {
            numArrToInt = numArrToInt * 10 + j;
        }

        numArrToInt += k;

        List<Integer> ans = new ArrayList<>();
        while (numArrToInt > 0) {
            int modulus = numArrToInt % 10;
            ans.add(0, modulus);

            numArrToInt /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 0, 0};
        int k = 34;

        AddToArrayFormInteger addToArrayFormInteger = new AddToArrayFormInteger();
        System.out.println(addToArrayFormInteger.addToArrayForm(num, k));
    }
}
