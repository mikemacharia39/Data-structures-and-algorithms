package javasolutionsforalgorithms.toptal;

import java.util.Arrays;

/**
 * A vending machine has the following denominations: 1c, 5c, 10c, 25c, 50c, and $1.
 * Your task is to write a program that will be used in a vending machine to return change.
 * Assume that the vending machine will always want to return the least number of coins or notes.
 * Devise a function getChange(M, P) where M is how much money was inserted into the machine and P the price of the item selected,
 * that returns an array of integers representing the number of each denomination to return.
 * <p>
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

        //int[] den = {1,5,10,25,50,100};
        int numberOfDenominations = 6;
        int[] ans = new int[numberOfDenominations];

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

        ans[numberOfDenominations-1] = whole; // the last

        return ans;
    }

    public static void main(String[] args) {
        ChangeInDenominations changeInDenominations = new ChangeInDenominations();
        double money = 5;
        double price = 0.89;
        // balance = 4.11
        System.out.println(Arrays.toString(changeInDenominations.getChange(money, price)));
    }
}
