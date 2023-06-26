package baekjoon._2903

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()

    var count = 1
    var a = 9
    var b = 3

    while (count < n) {
        b += Math.pow(2.0, count.toDouble()).toInt()
        a = b * b
        count++
    }

    sb.append(a)
    print(sb)

}
