package kotlinsolutionsforalgorithms.revision.general

fun main() {
    //readingInput()
    readingInputAndOperator()
}

fun readingInputAndOperator() {
    println("Enter the numbers and operator separated by space: e.g. 5 + 3 or 5 plus 3")
    val (firstNum, operator, secondNum) = readln().split(" ")
    val a = firstNum.toInt()
    val b = secondNum.toInt()
    when (operator) {
        "+", "plus" -> {
            val sum = a + b
            println(sum)
        }
        "-", "minus" -> {
            val diff = a - b
            println(diff)
        }
        "*", "times" -> {
            val product = a * b
            println(product)
        }
        else -> println("Unknown operator")
    }
}

fun readingInput() {
    println("Enter the numbers separated by space:")
    val arr = readln().split(" ").map { it.toInt() }
    val sum = arr.sum()
    println(sum)
}