
fun main(){
    println("Выполнение курсового задания №1:")
    task6a1()

    println("Выполнение курсового задания №2:")
    task6a2()
}

fun <T, R> List<T>.safeMap(transform: (T) -> R, defaultValue: R): List<R> {
    val result = mutableListOf<R>()
    for (item in this) {
        try {
            result.add(transform(item))
        } catch (e: Exception) {
            result.add(defaultValue)
        }
    }
    return result
}

fun task6a1() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val safeResults = numbers.safeMap({
        if (it % 2 == 0) throw Exception("Even number")
        it * it
    }, -1)
    println(safeResults) // [1, -1, 9, -1, 25]
}

fun geometricMean(): (Double, Double) -> Double {
    return { a, b -> Math.sqrt(a * b) }
}

fun task6a2() {
    val calculateGeometricMean = geometricMean()
    val result = calculateGeometricMean(4.0, 16.0)
    println(result) // 8.0
}
