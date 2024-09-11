package kotlinsolutionsforalgorithms.hackerrank.implementation

class BillDivision {

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