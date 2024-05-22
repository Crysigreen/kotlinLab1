

fun main(args: Array<String>) {
    task1()
    println("/////////////////////")
    task2()
    println("/////////////////////")
    //Task3()
    task3_1()
    println("/////////////////////")
    task4()
    println("/////////////////////")
    task5()
    println("/////////////////////")
    task6()
}

fun task1(){
    println("Иван")

    println(35)

    println(true)
}

fun task2(){
    var int: Int = 5
    var char: Char = 'F'
    var string: String = "Привет"
    var double: Double = 90.2

    val constantNumber: Int = 67

    println(string)
}

fun task3(){
    val input = readlnOrNull()

    if (input != null && input.length == 4 && input.all { it.isDigit() }){
        var num = input.toInt()
        val list = mutableListOf<Int>()

        list.add(num/1000)
        list.add((num%1000)/100)
        list.add((num % 100) / 10)
        list.add(num%10)

        println("Результат ${list.joinToString(", ")}")
    }
    else{
        println("Введите коректное число")
    }
}

fun task3_1(){
    val input = readlnOrNull()

    if (input != null && input.length == 4 && input.all { it.isDigit() }) {
        val num = input.toInt()
        val list = input.map { it.toString().toInt() }
        println("Результат ${list.joinToString(", ")}")
    } else {
        println("Введите коректное число")
    }
}

fun task4(){
    val input = 2642

    val years = input / 365
    val days = input % 365
    val week = days / 7
    println("Лет: ${years}, недель: ${week}, дней: ${days}")
}

fun task5(){
    val input = readLine()?.toIntOrNull()

    if (input != null) {
        val result = input.toString() + (input * 2)
        println("Результат: $result")
    } else {
        println("Введите число")
    }
}

fun task6(){
    println("Имя:")
    val name = readlnOrNull()

    println("Возраст:")
    val age = readLine()?.toIntOrNull()

    if (name != null && age != null) {
        println("Привет, $name! Тебе уже $age лет.")
    } else {
        println("Введите коректные данные")
    }
}