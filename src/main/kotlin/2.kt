

fun main(args: Array<String>){
    task21()
    println("/////////////////////////")
    task22()
    println("/////////////////////////")
    task23()
    println("/////////////////////////")
    task24()
    println("/////////////////////////")
    task25()
    println("/////////////////////////")
    task26()
    println("/////////////////////////")
    task27()
}


fun task21(){
    if((20 % 17) > 0){
        println("Получилось значение большее чем ноль!")
    }else{
        println("Меньше чем ноль")
    }
}

fun task22(){

    println("Введите возраст: ")
    val age = readln().toIntOrNull()

    if (age != null && age>18) {
        println("Вам уже все можно")
    }else if(age==18){
        println("Ура, Вам 18 лет!")
    }else{
        println("Вы еще слишком молоды")
    }
}

fun task23() {
    val a = 2
    val b = 6

    println("У вас есть числа: $a и $b")
    println("1. Добавить")
    println("2. Отнять")
    println("0. Ничего")

    println("Введите номер действия:")
    val result = readLine()?.toIntOrNull()

    when (result) {
        1 -> println("Результат сложения: ${a + b}")
        2 -> println("Результат вычитания: ${a - b}")
        0 -> println("Ничего.")
        else -> println("Некорректный ввод")
    }
}

fun task24(){
    val day = readLine()?.toIntOrNull()

    when(day){
        1-> println("Понедельник")
        2-> println("Вторник")
        3-> println("Среда")
        4-> println("Четверг")
        5-> println("Пятница")
        6-> println("Суббота")
        7-> println("Воскресенье")
    }
}

fun task25(){
    println("Введите три числа:")
    val num1 = readLine()?.toIntOrNull()
    val num2 = readLine()?.toIntOrNull()
    val num3 = readLine()?.toIntOrNull()

    if (num1 != null && num2 != null && num3 != null) {
        if (num1 != num2 && num1 != num3 && num2 != num3) {
            val sortNumbers = listOf(num1, num2, num3).sorted()
            val middleNumber = sortNumbers[1]
            println("Среднее число: $middleNumber")
        } else {
            println("Ошибка: Числа совпадают.")
        }
    } else {
        println("Ошибка: Пожалуйста, введите корректные числа.")
    }
}

fun task25_1(){
    println("Введите три числа:")
    val num1 = readLine()?.toIntOrNull()
    val num2 = readLine()?.toIntOrNull()
    val num3 = readLine()?.toIntOrNull()

    if (num1 != null && num2 != null && num3 != null) {
        if (num1 != num2 && num1 != num3 && num2 != num3) {
            val midNumber = when {
                (num1 > num2 && num1 < num3) || (num1 < num2 && num1 > num3) -> num1
                (num2 > num1 && num2 < num3) || (num2 < num1 && num2 > num3) -> num2
                else -> num3
            }
            println("Среднее число: $midNumber")
        } else {
            println("Числа совпадают.")
        }
    } else {
        println("Некорректный ввод")
    }
}

fun task26(){
    println("Введите экспорт:")
    val export = readLine()?.toIntOrNull()
    println("Введите экспорт:")
    val import = readLine()?.toIntOrNull()

    if (export != null && import != null) {
        val balance = export - import
        if (balance > 0) {
            println("Ваша прибыль составляет: $balance")
        } else if (balance < 0) {
            println("Ваши убытки составили: ${-balance}")
        } else {
            println("Сальдо равно нулю.")
        }
    } else {
        println("Введите корректные данные")
    }
}

fun task27(){
    println("Введите первое число")
    val num1 = readLine()?.toIntOrNull()
    println("Введите второе число:")
    val num2 = readLine()?.toIntOrNull()

    if (num1 != null && num2 != null) {
        val result = if (num1 % 2 == 0 && num2 % 2 == 0) true else false
        println("Переменные четные: $result")
    }
    else {
        println("Введите корректные данные")
    }
}