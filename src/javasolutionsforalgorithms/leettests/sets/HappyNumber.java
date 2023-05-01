package javasolutionsforalgorithms.leettests.sets;

import java.util.HashSet;

/**
 * A happy number is one in which the sum of each digit squared eventually ends in the number 1.
 * 23 is a happy number because 2^2 + 3^2 = 13, 1^2 + 3^2 = 10, 1^2 + 0^2 = 1
 */
public class HappyNumber {

    //=========== SOLUTION 1 ===========

    public boolean isHappy(int n) {
        HashSet<Integer> nums = new HashSet<>();
        while (n != 1 && !nums.contains(n)) {
            nums.add(n);
            n = sumNumbers(n);
        }

        return n == 1;
    }


    //=========== SOLUTION 2 ===========

    private final HashSet<Integer> set = new HashSet<>();
    public boolean isHappy2(int n) {
        if (n == 1) { return true; }

        n = sumNumbers(n);
        if (set.contains(n) && n != 1) {
            return false;
        } else {
            set.add(n);
            return isHappy2(n);
        }
    }

    /**
     * if the number is 19
     * modulus 19 % 10 = 9 | 19/10 = 1
     * modulus 1 % 10 = 1  | 1/10 = 0
     */
    private int sumNumbers(int n) {
        int sum = 0;

        while (n > 0) {
            int modulus = n % 10;
            sum += modulus * modulus;
            n = n/10;
        }

        return sum;
    }
}
