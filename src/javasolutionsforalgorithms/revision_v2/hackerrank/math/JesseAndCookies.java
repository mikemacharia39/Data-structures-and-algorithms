package javasolutionsforalgorithms.revision_v2.hackerrank.math;

import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://www.hackerrank.com/challenges/jesse-and-cookies/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign">...</a>
 *
 * Jesse loves cookies and wants the sweetness of some cookies to be greater than value k.
 * To do this, two cookies with the least sweetness are repeatedly mixed.
 * This creates a special combined cookie with: sweetness=(1 + Least sweet cookie + 2 * 2nd least sweet cookie).
 *
 * This occurs until all the cookies have a sweetness >= k.
 *
 * Given the sweetness of a number of cookies, determine the minimum number of operations required.
 * If it is not possible, return -1.
 *
 * Example:
 * k = 9
 * A = {2, 7 ,3 ,6 ,4 ,6}
 *
 * Answer = 4
 * Explanation:
 * The smallest values are 2 and 3, so the first operation combines them to create a cookie with sweetness = 1*2 + 2*3 = 8
 * A = {8, 7, 6, 4, 6}
 * The next operation combines the cookies with sweetness 4 and 6, to create a cookie with sweetness = 1*4 + 2*6 = 16
 * A = {16, 8, 7, 6}
 * The next operation combines the cookies with sweetness 6 and 7, to create a cookie with sweetness = 1*6 + 2*7 = 20
 * A = {20, 16, 8}
 * The final operation combines the cookies with sweetness 8 and 16, to create a cookie with sweetness = 1*8 + 2*16 = 40
 * A = {40, 20}
 */
public class JesseAndCookies {

    /**
     * The logic is to use a priority queue to keep track of the least sweet cookies. The priority queue is usd because it
     * is a min heap and the least sweet cookie is always at the top. The while loop is used to keep track of the number of
     * operations required to get the sweetness >= k. The poll() method is used to remove the least sweet cookie and the
     * peek() method is used to get the least sweet cookie. The add() method is used to add the new cookie with sweetness
     * @param k the sweetness
     * @param A the list of cookies
     * @return the number of operations required to get the sweetness >= k
     */
    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(A);
        int count = 0;
        while (pq.size() > 1 && pq.peek() < k) {
            int least = pq.poll();
            int secondLeast = pq.poll();
            pq.add(least + 2 * secondLeast);
            count++;
        }
        return pq.peek() >= k ? count : -1;
    }

    public static void main(String[] args) {
        System.out.println(cookies(9, List.of(2, 7, 3, 6, 4, 6))); // 4
    }
}
