package kotlinsolutionsforalgorithms.hackerrank.math

import kotlin.math.pow

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