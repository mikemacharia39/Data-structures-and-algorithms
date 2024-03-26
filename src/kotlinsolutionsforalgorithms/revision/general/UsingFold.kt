package kotlinsolutionsforalgorithms.revision.general

/**
 * Fold is a higher-order function that applies a binary operation to an initial accumulator value and all elements of a collection,
 * from left to right, and returns the final accumulator value.
 */
fun main() {
    val cookies = listOf(
        Cookie("Chocolate Chip", 1.5),
        Cookie("Oatmeal Raisin", 2.0),
        Cookie("Peanut Butter", 2.5)
    )

    val totalPrice = cookies.fold(0.0) {total, cookie ->
        total + cookie.price
    }

    println("Total price: $totalPrice")
}

data class Cookie(val name: String, val price: Double)