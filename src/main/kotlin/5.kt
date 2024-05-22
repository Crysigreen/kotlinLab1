

fun main() {

}
////////////////////////////////////////////////////////////
fun roundNumber(number: Int): String {
    return if (number >= 1000) {
        "${number / 1000}K"
    } else {
        number.toString()
    }
}
fun task51(){
    println("Введите число:")
    val input = readln().toIntOrNull()
    if (input == null) {
        println("Введите корректное число.")
        return
    }
    val result = roundNumber(input)
    println("Результат: $result")
}
////////////////////////////////////////////////////////////
fun Int.getYearEnding(): String {
    return when {
        this % 100 in 11..14 -> "$this лет"
        this % 10 == 1 -> "$this год"
        this % 10 in 2..4 -> "$this года"
        else -> "$this лет"
    }
}
fun task52(){
    println("Введите количество лет:")
    val input = readln().toIntOrNull()

    if (input == null) {
        println("Введите корректное число.")
        return
    }

    val result = input.getYearEnding()
    println("Результат: $result")
}
////////////////////////////////////////////////////////////
fun calculateDiscountedPrice(originalPrice: Double, discountPercentage: Double): Double {
    val discount = originalPrice * (discountPercentage / 100)
    val finalPrice = originalPrice - discount
    return "%.2f".format(finalPrice).toDouble()
}
fun task53(){
    println("Введите исходную цену товара:")
    val originalPrice = readln().toDoubleOrNull()
    println("Введите процент скидки:")
    val discountPercentage = readln().toDoubleOrNull()

    if (originalPrice == null || discountPercentage == null) {
        println("Введите корректные значения.")
        return
    }

    val finalPrice = calculateDiscountedPrice(originalPrice, discountPercentage)
    println("Цена товара с учетом скидки: $finalPrice")
}

////////////////////////////////////////////////////////////
fun countWords(input: String): Int {
    return input.split(Regex("\\s+|[,.!?;:]")).filter { it.isNotEmpty() }.count()
}
fun task54(){
    println("Введите строку:")
    val input = readln()

    val wordCount = countWords(input)
    println("Количество слов в строке: $wordCount")
}