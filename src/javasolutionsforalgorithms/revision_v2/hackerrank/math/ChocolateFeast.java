package javasolutionsforalgorithms.revision_v2.hackerrank.math;

/**
 * <a href="https://www.hackerrank.com/challenges/chocolate-feast/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign">...</a>
 *
 * Little Bobby loves chocolate. He frequently goes to his favorite 5&10 store, Penny Auntie, to buy them.
 * They are having a promotion at Penny Auntie. If Bobby saves enough wrappers, he can turn them in for a free chocolate.
 *
 * Example
 * n = 15
 * c = 3
 * m = 2
 *
 * He has 15 to spend, bars cost 3, and he can turn in 2 wrappers to receive another bar.
 * Initially, he buys 5 bars and has 5 wrappers after eating them.
 * He turns in 4 of them, leaving him with 1, for 2 more bars.
 * After eating those two, he has 2 wrappers, turns in 2 leaving him with 3 wrapper and his new bar.
 * Once he eats that one, he has 2 wrappers and turns them in for another bar.
 * After eating that one, he only has 1 wrapper, and his feast ends. Overall, he has eaten 9 bars.
 */
public class ChocolateFeast {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param n - initial amount of money
     * @param c - the cost of a chocolate bar
     * @param m - the number of wrappers he can turn in for a free bar
     * @return
     */
    public static int chocolateFeast(int n, int c, int m) {
        //int n: Bobby's initial amount of money
        //int c: the cost of a chocolate bar
        //int m: the number of wrappers he can turn in for a free bar

        int chocolateBars = n / c;
        int wrappers = chocolateBars;

        while (wrappers >= m) {

            int additionalChocolate = wrappers/m;
            wrappers = wrappers % m;

            chocolateBars += additionalChocolate;
            wrappers += additionalChocolate;
        }

        return chocolateBars;
    }
}
