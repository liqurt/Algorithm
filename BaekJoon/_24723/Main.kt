package baekjoon._24723

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.pow

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val result = 2.toDouble().pow(n.toDouble()).toInt()
    sb.append(result)
    print(sb)
}

// 1 = 2
// 2 = 4
// 3 = 8