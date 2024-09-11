package kotlinsolutionsforalgorithms.hackerrank.implementation

/**
 * https://www.hackerrank.com/challenges/bon-appetit/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
class BillDivision {
    //bill: an array of integers representing the cost of each item ordered
    //k: an integer representing the zero-based index of the item Anna doesn't eat
    //b: the amount of money that Anna contributed to the bill
    fun bonAppetit(bill: Array<Int>, k: Int, b: Int): Unit {
        var sum = 0
        for (i in bill.indices) {
            if (i != k) {
                sum += bill[i]
            }
        }
        sum /= 2
        if (sum == b) {
            println("Bon Appetit")
        } else {
            println(b - sum)
        }
    }

    fun bonAppetit2(bill: Array<Int>, k: Int, b: Int): Unit {
        val sum = (bill.sum() - bill[k]) / 2
        if (sum == b) {
            println("Bon Appetit")
        } else {
            println(b - sum)
        }
    }
}