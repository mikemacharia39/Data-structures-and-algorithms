package javasolutionsforalgorithms.toptal;

import java.util.Arrays;

/**
 * A vending machine has the following denominations: 1c, 5c, 10c, 25c, 50c, and $1.
 * Your task is to write a program that will be used in a vending machine to return change.
 * Assume that the vending machine will always want to return the least number of coins or notes.
 * Devise a function getChange(M, P) where M is how much money was inserted into the machine and P the price of the item selected,
 * that returns an array of integers representing the number of each denomination to return.
 *
 * Example:
 * getChange(5, 0.99) 4.01 // should return [1,0,0,0,0,4]
 */
public class ChangeInDenominations {

    public int[] getChange(double money, double price) {
        double change = money - price;
        // 4.01 get whole number
        int wholeNoDecimal = (int)(change*100);
        int whole = wholeNoDecimal/100;
        int cents = wholeNoDecimal%100;

        int[] den = {1,5,10,25,50};
        int[] ans = new int[den.length];

        while (cents > 0) {
            if (cents >= 50) {
                cents -= 50;
                ans[4]++;
            } else if (cents >= 25) {
                cents -= 25;
                ans[3]++;
            } else if (cents >= 10) {
                cents -= 10;
                ans[2]++;
            } else if (cents >= 5) {
                cents -= 5;
                ans[1]++;
            } else {
                cents -= 1;
                ans[0]++;
            }
        }

        ans[den.length-1] = whole;

        return ans;
    }

    /**
     * Original Ans
     * @param money
     * @param price
     * @return
     */
    public int[] getChange3(double money, double price) {
        double change = money - price;
        // 4.01 get whole number
        int wholeNoDecimal = (int)(change*100);
        int whole = wholeNoDecimal/100;
        int cents = wholeNoDecimal%100;

        System.out.println(cents);

        int[] den = {1,5,10,25,50};
        int[] ans = new int[den.length];

        while (cents > 0) {

            for (int i = den.length-1; i >= 1; i--) {
                if (den[i] >= cents) {
                    cents -= den[i];
                    ans[den.length - i-1]++;
                }

                if (cents <= 0) {
                    break;
                }
            }
        }

        ans[den.length-1] = whole;

        return ans;
    }

    /**
     * Original Ans
     * @param money
     * @param price
     * @return
     */
    public int[] getChange2(double money, double price) {
        double change = money - price;
        // 4.01 get whole number
        int whole = (int) change;
        double cents = change - whole;

        int[] den = {1,5,10,25,50};
        int[] ans = new int[den.length];

        while (cents > 0) {
            for (int i = den.length-1; i >= 1; i--) {
                if (den[i] >= cents) {
                    cents -= den[i];
                    ans[i]++;
                }
            }
        }

        ans[den.length-1] = whole;

        return ans;
    }

    public static void main(String[] args) {
        ChangeInDenominations changeInDenominations = new ChangeInDenominations();
        double money = 5;
        double price = 0.89;
        System.out.println(Arrays.toString(changeInDenominations.getChange(money, price)));
    }
}
