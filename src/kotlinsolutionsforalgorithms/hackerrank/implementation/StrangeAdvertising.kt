package kotlinsolutionsforalgorithms.hackerrank.implementation
/**
 * https://www.hackerrank.com/challenges/strange-advertising/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign
 */
class StrangeAdvertising {
    fun viralAdvertising(n: Int): Int {
        var shared = 5
        var cumulative = 0
        for (i in 1..n) {
            val liked = shared / 2
            cumulative += liked
            shared = liked * 3
        }
        return cumulative
    }
}

fun main() {
    val strangeAdvertising = StrangeAdvertising()
    println(strangeAdvertising.viralAdvertising(5)) // 24
}