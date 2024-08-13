package kotlinsolutionsforalgorithms.leetcode.arrays

class ContainsDuplicate {

    fun containsDuplicate(numbers: IntArray): Boolean {
        return numbers.toSet().size < numbers.size
    }
}

fun main() {
    val containsDuplicate = ContainsDuplicate()
}