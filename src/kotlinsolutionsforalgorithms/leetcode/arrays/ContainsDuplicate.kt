package kotlinsolutionsforalgorithms.leetcode.arrays

class ContainsDuplicate {

    fun containsDuplicate(numbers: IntArray): Boolean {
        return numbers.toSet().size < numbers.size
    }
}

fun main() {
    val testCases = listOf(
        intArrayOf(1, 2, 3, 4, 5) to false,  // No duplicates
        intArrayOf(1, 2, 3, 4, 5, 1) to true,  // Duplicate 1
        intArrayOf(1, 1, 1, 1, 1) to true,  // All duplicates
        intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) to false,  // No duplicates, larger array
        intArrayOf() to false,  // Empty array
        intArrayOf(0, 0) to true,  // Duplicate 0
        intArrayOf(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 500) to true  // Duplicate 500
    )
    val duplicate = ContainsDuplicate()
    // Running test cases
    for ((input, expected) in testCases) {
        val result = duplicate.containsDuplicate(input)
        println("Input: ${input.joinToString(", ")} -> Output: $result, Expected: $expected")
        assert(result == expected) { "Test failed for input: ${input.joinToString(", ")}" }
    }
}