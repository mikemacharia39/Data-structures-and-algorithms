package kotlinsolutionsforalgorithms.hackerrank.greedy

/**
 * <a href="https://www.hackerrank.com/challenges/mark-and-toys/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign">...</a>
 *
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
class MarkAndToys {
    companion object { // companion object is similar to static in Java
        fun markAndToys(arr: Array<Int>, k: Int): Int {
            var sum = 0
            var count = 0
            arr.sort()
            for (i in arr.indices) {
                sum += arr[i]
                if (sum > k) {
                    break
                }
                count++
            }
            return count
        }
    }
}

fun main() {
    MarkAndToys.markAndToys(arrayOf(1, 12, 5, 111, 200, 1000, 10), 50).also { println(it) }
}