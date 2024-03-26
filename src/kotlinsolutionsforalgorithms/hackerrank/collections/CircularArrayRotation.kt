package kotlinsolutionsforalgorithms.hackerrank.collections

/**
 * /**
 *  * <a href="https://www.hackerrank.com/challenges/circular-array-rotation/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign">...</a>
 *  *
 *  * John Watson knows of an operation called a right circular rotation on an array of integers.
 *  * One rotation operation moves the last array element to the first position and shifts all remaining elements right one.
 *  * To test Sherlock's abilities, Watson provides Sherlock with an array of integers.
 *  * Sherlock is to perform the rotation operation a number of times then determine the value of the element at a given position.
 *  *
 *  * For each array, perform a number of right circular rotations and return the values of the elements at the given indices.
 *  */
 */
fun circularArrayRotation(a: Array<Int>, k: Int, queries: Array<Int>): Array<Int> {
    val n = a.size
    val newK = k % n

    val rotatedArray = arrayOf<Int>() // Array(n) { 0 } // <--- This is the correct way to initialize an array of size n

    for (i in a.indices) {
        val newIndex = (n - newK + i) % n
        rotatedArray[i] = a[newIndex]
    }

    val result = Array(queries.size) { 0 }
    for (i in queries.indices) {
        result[i] = rotatedArray[queries[i]]
    }

    return result
}