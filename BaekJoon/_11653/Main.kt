package baekjoon._11653

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    var n = br.readLine().toInt() // 72
    val rootOfN = sqrt(n.toDouble()).toInt() // 8

    var i = 2
    if (n == 1) {
    } else {
        while (i <= rootOfN || n != 1) {
            if (n % i == 0) {
                n /= i
                sb.append(i).append("\n")
            } else {
                i++
            }
        }
        sb.deleteCharAt(sb.lastIndex)
        print(sb)
    }
}