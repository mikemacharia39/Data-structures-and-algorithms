package kotlinsolutionsforalgorithms.hackerrank.math

import kotlin.math.pow

/**
 * <a href="https://www.hackerrank.com/challenges/marcs-cakewalk/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign">...</a>
 *
 * Marc loves cupcakes, but he also likes to stay fit. Each cupcake has a calorie count,
 * and Marc can walk a distance to expend those calories.
 * If Marc has eaten  cupcakes so far, after eating a cupcake with c calories he must walk at least 2^j * c miles to maintain his weight.
 *
 * Example:
 * calories = [5, 10, 7]
 * answer = 44, because the minimum miles he must walk is 2^0 * 10 + 2^1 * 7 + 2^2 * 5 = 44
 */
fun main() {
    marcsCakewalk(listOf(5,10,7)).also(::println)
    println("=======================")
    marcCakeWalkWithDynamicInput()
}

fun marcsCakewalk(calorie: List<Int>): Long {
    val sortedCalorie = calorie.sortedDescending()
    var miles = 0L
    for (i in sortedCalorie.indices) {
        miles += sortedCalorie[i] * 2.0.pow(i).toLong()
    }
    return miles
}

fun marcCakeWalkWithDynamicInput() {
    println("Enter the number of cupcake calories:")
    val calories = readln().split(" ").map { it.toInt() }.sortedDescending()
    var miles = 0L
    for (i in calories.indices) {
        miles += calories[i] * 2.0.pow(i.toDouble()).toLong()
    }
    println(miles)
}