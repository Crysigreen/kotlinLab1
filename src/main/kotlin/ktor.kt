import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.*
import java.io.File
import java.net.URL

suspend fun downloadImage(client: HttpClient, url: String, filePath: String) {
    val response: ByteArray = client.get(url).body()
    File(filePath).writeBytes(response)
}

suspend fun downloadImagesWithCustomNames(client: HttpClient, urls: List<String>, outputDir: String) = coroutineScope {
    urls.mapIndexed { index, url ->
        async(Dispatchers.IO) {
            val fileName = "$index.image.jpg"
            val filePath = "$outputDir/$fileName"
            downloadImage(client, url, filePath)
        }
    }.awaitAll()
}

suspend fun downloadImagesWithOriginalNames(client: HttpClient, urls: List<String>, outputDir: String) = coroutineScope {
    urls.map { url ->
        async(Dispatchers.IO) {
            val fileName = URL(url).path.split("/").last()
            val filePath = "$outputDir/$fileName"
            downloadImage(client, url, filePath)
        }
    }.awaitAll()
}

fun taskKtor(baseDir: String) = runBlocking {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    val urls = List(100) { "http://localhost:8080/images/image_$it.jpg" }

    val customNamesDir = "$baseDir/CustomNames"
    val originalNamesDir = "$baseDir/OriginalNames"

    File(customNamesDir).mkdirs()
    File(originalNamesDir).mkdirs()

    println("Скачивание файлов с кастомным названием:")
    downloadImagesWithCustomNames(client, urls, customNamesDir)

    println("Скачивание файлов с оригинальным названием:")
    downloadImagesWithOriginalNames(client, urls, originalNamesDir)

    client.close()
}

fun main() {

    val baseDir = "data"
    println("Выполнение курсового задания №2:")
    taskKtor(baseDir)
}