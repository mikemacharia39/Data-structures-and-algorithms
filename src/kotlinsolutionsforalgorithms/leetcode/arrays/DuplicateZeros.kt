package kotlinsolutionsforalgorithms.leetcode.arrays

import java.util.LinkedList
import java.util.Queue

/**
 *
 * https://leetcode.com/problems/duplicate-zeros/
 *
 * Given a fixed-length integer array arr, duplicate each occurrence of zero,
 * shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place and do not return anything.
 *
 * Example 1:
 *
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 *
 * Example 2:
 *
 * Input: arr = [1,2,3]
 * Output: [1,2,3]
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 */

class DuplicateZeros {

    fun duplicateZeros(arr: IntArray): Unit {
        val queue: Queue<Int> = LinkedList();

        arr.forEachIndexed { index, item ->
            if (item == 0) {
                queue.add(0)
                queue.add(0)
            } else {
                queue.add(item)
            }

            val first = queue.poll()
            arr[index] = first
        }
    }

    fun duplicateZeros1(arr: IntArray): Unit {
        var index: Int = 0;
        while (index < arr.size) {
            if (arr[index] == 0) {
                shift(arr, index + 1)
                if (index != arr.lastIndex) {
                    arr[index + 1] = 0
                    index++
                }
            }
            index++
        }
    }

    private fun shift(arr: IntArray, index: Int): Unit {
        for (i in arr.lastIndex downTo index) {
            arr[i] = arr[i - 1]
        }
    }
}

fun main() {
    val duplicateZeros = DuplicateZeros();

    val arr = intArrayOf(1, 0, 2, 3, 0, 4, 5, 0);
    duplicateZeros.duplicateZeros(arr)

    println(arr.asList())
}