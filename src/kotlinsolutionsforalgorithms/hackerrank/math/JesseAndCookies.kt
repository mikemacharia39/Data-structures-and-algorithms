package kotlinsolutionsforalgorithms.hackerrank.math

import java.util.*

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
fun main() {
    cookies(9, arrayOf(2, 7, 3, 6, 4, 6)).also(::println)
}

fun cookies(k: Int, A: Array<Int>): Int {

    val priorityQueue = PriorityQueue<Int>()
    priorityQueue.addAll(A)
    var count = 0

    while (priorityQueue.size > 1 && priorityQueue.peek() < k) {
        val leastSweet = priorityQueue.poll()
        val secondLeastSweet = priorityQueue.poll()
        val newCookie = leastSweet + 2 * secondLeastSweet
        priorityQueue.add(newCookie)
        count++
    }

    return if (priorityQueue.peek() >= k) count else -1
}