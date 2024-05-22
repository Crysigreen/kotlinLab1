
fun main(args: Array<String>){
task46()
}

fun task41(){
    println("Введите первое число:")
    val num1 = readln().toIntOrNull()
    println("Введите второе число:")
    val num2 = readln().toIntOrNull()

    if (num1 == null || num2 == null || num1 == num2) {
        println("Введите два различных целых числа.")
        return
    }

    val (start, end) = if (num1 < num2) num1 to num2 else num2 to num1
    val rangeList = (start..end).toList()

    println("Массив: $rangeList")
}

fun task42(){
    val arrayList = mutableListOf<Int>()
    arrayList.addAll(listOf(8, 21, 5, 90, 11, 0))
    arrayList.add(0, 90)
    arrayList.removeAt(4)
    arrayList.add(-35)

    println("Массив: $arrayList")
}

fun task43(){
    println("Введите элементы массива через пробел:")
    val input = readln().split(" ").mapNotNull { it.trim().toIntOrNull() }
    if (input.isEmpty()) {
        println("Массив пуст.")
        return
    }
    val min = input.minOrNull()
    val max = input.maxOrNull()
    println("Минимальный элемент: $min")
    println("Максимальный элемент: $max")
}

fun task44(){
    println("Введите элементы массива через пробел:")
    val input = readln().split(" ").mapNotNull { it.trim().toIntOrNull() }
    if (input.size < 2) {
        println("Массив должен содержать как минимум два элемента.")
        return
    }
    val sortedList = input.sorted()
    val secondSmallest = sortedList[1]
    println("Второй самый маленький элемент: $secondSmallest")
}

fun task45(){
    println("Введите элементы массива через пробел:")
    val input = readln().split(" ").mapNotNull { it.trim().toIntOrNull() }

    val sortedList = input.sorted()

    println("Отсортированный массив: $sortedList")
}

fun task46(){
    println("Введите элементы массива через пробел:")
    val input = readln().split(" ").mapNotNull { it.toIntOrNull() }
    if (input.isEmpty()) {
        println("Массив пуст.")
        return
    }
    val average = input.average()
    val aboveAverageList = input.filter { it > average }
    println("Среднее арифметическое: $average")
    println("Элементы больше среднего: $aboveAverageList")
}