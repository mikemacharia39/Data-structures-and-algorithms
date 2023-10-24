package javasolutionsforalgorithms.revision_v2.hackerrank.maps;

import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/sock-merchant/problem">...</a>
 *
 * There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock,
 * determine how many pairs of socks with matching colors there are.
 *
 * Example
 * n = 7
 * ar = [1,2,1,2,1,3,2]
 * There is one pair of 1 and one of 2. There are three odd socks left, one of each color. The number of pairs is 2.
 */
public class SalesByMatch {

    public static int sockMerchant(int n, List<Integer> ar) {
        HashMap<Integer, Integer> groupedSocks = new HashMap<>();
        for (int num : ar) {
            groupedSocks.put(num, groupedSocks.getOrDefault(num, 0) + 1);
        }

        int pairs = 0;

        for (int sockFrequency : groupedSocks.values()) {
            pairs += sockFrequency/2;
        }

        return pairs;
    }
}
