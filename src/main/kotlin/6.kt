import kotlinx.coroutines.*
import java.time.LocalTime
import kotlin.random.Random
import kotlin.system.measureTimeMillis


fun main() {
    //println("Выполнение задания №1:")
    //task61()

    println("Выполнение задания №2:")
    task62()

    println("Выполнение задания №3:")
    task63()

    println("Выполнение задания №4:")
    task64()
}

// Задание №1: Точное время
fun task61() = runBlocking {
    launch {
        while (true) {
            println(LocalTime.now())
            delay(1000L)
        }
    }
}

// Задание №2: Математические операции
suspend fun mathOperation(a: Double, b: Double): Double {
    delay(2000L) // имитация длительной операции
    return Math.pow(a, b) + Math.sqrt(a * b)
}

fun task62() = runBlocking {
    val result = async { mathOperation(2.0, 3.0) }
    println("Идут вычисления...")
    println("Результат вычисления: ${result.await()}")
}

// Задание №3: Эффективность
suspend fun checkEven(index: Int): Pair<Int, Boolean> {
    val number = Random.nextInt()
    return Pair(index, number % 2 == 0)
}

fun task63() = runBlocking {
    val results = mutableMapOf<Int, Boolean>()
    val time = measureTimeMillis {
        val jobs = List(100000) { index ->
            async {
                val result = checkEven(index)
                results[result.first] = result.second
            }
        }
        jobs.awaitAll()
    }
    val evenCount = results.values.count { it }
    println("Количество четных чисел: $evenCount")
    println("Общее время выполнения: $time ms")
}

// Задание №4: Быстрота
suspend fun <T> withTimeoutOrDefault(timeMillis: Long, defaultValue: T, block: suspend () -> T): T {
    return try {
        withTimeout(timeMillis) {
            block()
        }
    } catch (e: TimeoutCancellationException) {
        println("Too long body execution")
        defaultValue
    }
}

suspend fun longRunningTask(duration: Long): String {
    delay(duration)
    return "Task completed"
}

fun task64() = runBlocking {
    val shortTask = withTimeoutOrDefault(1000L, "Timeout") {
        longRunningTask(500L)
    }
    println(shortTask) // Output: Task completed

    val longTask = withTimeoutOrDefault(1000L, "Timeout") {
        longRunningTask(1500L)
    }
    println(longTask) // Output: Timeout
}

// main функция

