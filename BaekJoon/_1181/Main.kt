package baekjoon._1181

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val strarr = Array<String?>(n) { null }
    repeat(n) {
        val msg = br.readLine()
        if (!strarr.contains(msg))
            strarr[it] = msg
    }
    strarr.sortWith(compareBy<String?> { it?.length }.thenBy{it})

    repeat(n) {
        if (strarr[it] != null)
            sb.append(strarr[it]).append("\n")
    }
    sb.deleteCharAt(sb.length - 1)
    print(sb)
}