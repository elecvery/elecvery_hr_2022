import java.io.File
import java.io.InputStream
import java.time.LocalTime

fun main(args: Array<String>) {
    val basePath = "./"
    val costData = readCsv(File("$basePath/data/q1_cost.csv").inputStream())
    val stationData = readCsv(File("$basePath/data/q1_station.csv").inputStream())
    val sampleResult = readCsv(File("$basePath/data/q1_sample_result.csv").inputStream())

    println(costData)
    println(stationData)
    println(sampleResult)
}

fun readCsv(inputStream: InputStream): List<Map<String, String>> {
    val reader = inputStream.bufferedReader()
    val headers = reader.readLine().split(',')
    return reader.lineSequence()
        .filter { it.isNotBlank() }
        .map { headers.zip(it.split(',')).toMap() }
        .toList()
}
