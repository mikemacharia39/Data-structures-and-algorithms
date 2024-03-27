package javasolutionsforalgorithms.revision_v2.hackerrank.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some.
 * There are a number of different toys lying in front of him, tagged with their prices. Mark has only a certain amount to spend,
 * and he wants to maximize the number of toys he buys with this money.
 * Given a list of toy prices and an amount to spend, determine the maximum number of gifts he can buy.
 *
 * Note Each toy can be purchased only once.
 *
 * Example:
 * prices = {1,2,3,4}
 * k = 7
 * Answer = 3. He can buy at most 3 toys for 1+2+3 = 6. He can also buy 3 and 4. The maximum is 3.
 */
public class MarkAndToys {

    public static int maximumToys(List<Integer> prices, int k) {
        List<Integer> pricesCopy = new ArrayList<>(prices);
        pricesCopy.sort(Comparator.naturalOrder());
        int count = 0;
        for (int price : pricesCopy) {
            if (k - price >= 0) {
                k -= price;
                count += 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(maximumToys(List.of(1, 2, 3, 4), 7));
    }
}
