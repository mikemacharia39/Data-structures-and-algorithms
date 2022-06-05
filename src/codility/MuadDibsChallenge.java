package codility;

import java.util.Arrays;

/**
 * https://app.codility.com/c/run/cert3E6ZVD-6BW5KH6CS9SY6GC5/
 *
 * You want to buy public transport tickets for some upcoming days.
 * You know exactly the days on which you will be traveling. There are three types of ticket:
 *
 * 1-day ticket, costs 2, valid for one day;
 * 7-day ticket, costs 7, valid for seven consecutive days (e.g. if the first valid day is X, then the last valid day is X+6);
 * 30-day ticket, costs 25, valid for thirty consecutive days.
 * You want to pay as little as possible having valid tickets on your travelling days.
 *
 * You are given a sorted (in increasing order) array A of days when you will be traveling. For example, given:
 *
 *     A[0] = 1
 *     A[1] = 2
 *     A[2] = 4
 *     A[3] = 5
 *     A[4] = 7
 *     A[5] = 29
 *     A[6] = 30
 * you can buy one 7-day ticket and two 1-day tickets. The two 1-day tickets should be used on days 29 and 30.
 * The 7-day ticket should be used on the first seven days. The total cost is 11 and there is no possible way of paying less.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers that specifies days on which you will be traveling,
 * returns the minimum amount of money that you have to spend on tickets.
 *
 * For example, given the above data, the function should return 11, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * M is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..M];
 * N is an integer within the range [1..M];
 * array A is sorted in increasing order;
 * the elements of A are all distinct.
 */
public class MuadDibsChallenge {


    public static int cost()
    {
        int[] A = { 1, 2, 4, 5, 7, 8, 9, 10, 11, 12, 29, 30 };
        int res = MinCostWithDP(A);

        return Math.min(res, 25); //for buying a ticket for the whole month
    }

    private static int MinCostWithDP(int[] A)
    {
        int[] dp = new int[A.length];
        dp[0] = 2;

        for (int i = 1; i < A.length; i++)
        {
            int oneDay = 2 + dp[i - 1];
            int j = i - 1; //find the day before being able to buy a 7-day ticket

            while (j >= 0 && A[j] >= A[i] - 6)
                j--;

            int sevenDay = 7;
            if (j >= 0)
                sevenDay += dp[j];

            dp[i] = Math.min(oneDay, sevenDay);
        }

        System.out.println(Arrays.toString(dp));

        return dp[dp.length - 1];
    }

    private static int MinTicketCostHelper(int[] A, int index)
    {
        if (index >= A.length)
            return 0;

        ///choices we have area:
        /// 1. buy a 1-day ticket that costs 2
        /// 2. buy a 7-day-consecutive ticket that costs 7
        /// for each of those choices
        ///   choose
        ///   explore
        ///   unchoose
        ///

        int oneDayTicketCost = 2 + MinTicketCostHelper(A, index + 1);

        //if we want to buy seven day ticket, go until X + 6 since they must be consecutive
        int sevenDayTicketIndex = index + 1;
        while (sevenDayTicketIndex < A.length && A[sevenDayTicketIndex] <= A[index] + 6)
            sevenDayTicketIndex++;

        int seveDayTicketCost = 7 + MinTicketCostHelper(A, sevenDayTicketIndex);

        return Math.min(oneDayTicketCost, seveDayTicketCost);
    }

    //=====================================================================


    static int nums(int[] dates, int start, int end) {
        int count = 0;
        for (int i = 0; i < dates.length; i++) {
            if (i >= start && start <= end && i <= end) {
                count++;
            }
        }
        return count;
    }


    public static int cost2() {
        //                                           i   k
        int[] dates = {1, 2, 4, 5, 7, 8, 9, 10, 11, 12, 29, 30};
        //int[] dates = {1, 3, 5, 8, 9, 10};
                    // k 1+6
                    //              7
                    //  2, 4, 6, 8,
                    //              7
                    //                 9   11
        int n = dates.length;
        int min = 0;
        int k = n-1;
        int cost_for_1_day = 0;
        int cost_for_7_day = 0;
        for (int i = n-1; i >= 0; i--) {
            cost_for_1_day = cost_for_1_day + 2;
            if (dates[k] <= dates[i]+6 && nums(dates, i, k)%7 >= 4) {
                cost_for_7_day = 7;
                k = i;
            } else {
                k--;
            }

            if (cost_for_1_day < cost_for_7_day) {
                min = cost_for_1_day;

                System.out.println("Here: " + min + " | Date: " + dates[i]);
            } else if (cost_for_7_day < cost_for_1_day) {
                min = cost_for_7_day;
                System.out.println("Here 2: " + min + " | Date: " + dates[i]);
                cost_for_1_day = cost_for_7_day;
                cost_for_7_day = cost_for_7_day + 7;
            }
        }

        return Math.min(min, 25);
    }

    public static void main(String[] args) {
        System.out.println("Cost: " + MuadDibsChallenge.cost());
    }
}
