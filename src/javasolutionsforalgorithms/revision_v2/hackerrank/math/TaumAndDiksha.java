package javasolutionsforalgorithms.revision_v2.hackerrank.math;

/**
 * <a href="https://www.hackerrank.com/challenges/taum-and-bday/problem">...</a>
 *
 * Taum is planning to celebrate the birthday of his friend, Diksha.
 * There are two types of gifts that Diksha wants from Taum: one is black and the other is white.
 * To make her happy, Taum has to buy b black gifts and w white gifts.
 *
 * The cost of each black gift is bc units.
 * The cost of every white gift is wc units.
 * The cost to convert a black gift into white gift or vice versa is z units.
 * Determine the minimum cost of Diksha's gifts.
 *
 * Example
 * b = 3
 * w = 5
 * bc = 3
 * wc = 4
 * z = 1
 *
 * He can buy a black gift for 3 and convert it to a white gift for 1, making the total cost of each white gift 4.
 * That matches the cost of a white gift, so he can do that or just buy black gifts and white gifts.
 * Either way, the overall cost is 3 * 3 + 5 * 4 = 29.
 *
 * Function Description
 *
 * Complete the function taumBday in the editor below. It should return the minimal cost of obtaining the desired gifts.
 *
 * taumBday has the following parameter(s):
 *
 * int b: the number of black gifts
 * int w: the number of white gifts
 * int bc: the cost of a black gift
 * int wc: the cost of a white gift
 * int z: the cost to convert one color gift to the other color
 * Returns
 *
 * int: the minimum cost to purchase the gifts
 */
public class TaumAndDiksha {

    /**
     * More condensed logic
     * Condition 1: If the cost of black gifts + cost of converting black gifts to white gifts is less than cost of white gifts
     * then we can buy black gifts and convert them to white gifts
     * Condition 2: If the cost of white gifts + cost of converting white gifts to black gifts is less than cost of black gifts
     * then we can buy white gifts and convert them to black gifts
     * @param b
     * @param w
     * @param bc
     * @param wc
     * @param z
     * @return
     */
    public static long taumBday(int b, int w, int bc, int wc, int z) {
        long bp = Math.min(bc, wc + z);
        long wp = Math.min(wc, bc + z);
        return bp * b + wp * w;
    }

    /**
     * Simple Logic is to find the minimum cost of black and white gifts and then add them
     * @param b
     * @param w
     * @param bc
     * @param wc
     * @param z
     * @return
     */
    public static long taumBday1(int b, int w, int bc, int wc, int z) {
        long cost = 0;
        if (bc > wc + z) {
            cost = (long) b * (wc + z) + (long) w * wc;
        } else if (wc > bc + z) {
            cost = (long) b * bc + (long) w * (bc + z);
        } else {
            cost = (long) b * bc + (long) w * wc;
        }
        return cost;
    }
}
