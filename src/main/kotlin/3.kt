

fun main(args: Array<String>){

}

fun task31(){
    for (i in 1..5) {
        println(i.toString().repeat(i))
    }
}

fun task32(){
    val num = readln().toIntOrNull()
    var f = false
    if (num!=null){
        while (!f){
            if(num == 5){
                println("Угадали")
            }
            else{
                println("Не угадали")
            }
        }
    }
    else{
        println("Введите корректное число")
    }
}

fun task33(){
    println("Введите число:")
    val number = readln().toIntOrNull()
    if (number == null) {
        println("Введите корректное число.")
        return
    }
    println("Делители числа $number:")
    for (i in 1..number) {
        if (number % i == 0) {
            println(i)
        }
    }
}

fun task34(){
    println("Введите число:")
    val number = readln().toIntOrNull()
    if (number == null) {
        println("Введите корректное число.")
        return
    }
    val digits = number.toString().map { it.toString().toInt() }
    val evenCount = digits.count { it % 2 == 0 }
    val oddCount = digits.count { it % 2 != 0 }
    println("Четных цифр: $evenCount, Нечетных цифр: $oddCount")
}

fun task35(){
    var sum = 0
    for (i in 1..100) {
        if (i % 4 == 0) {
            sum += i
        }
    }
    println("Сумма чисел от 1 до 100, кратных 4: $sum")
}

fun task36(){
    var sum = 0
    var i = 5
    while (i <= 57) {
        if (i != 34 && i != 46 && i != 52) {
            sum += i
        }
        i++
    }
    println("Сумма всех чисел от 5 до 57, исключая 34, 46 и 52: $sum")
}