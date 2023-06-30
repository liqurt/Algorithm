package baekjoon._3009

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val points = Array(4) { IntArray(2) }

    repeat(3) {
        val (x, y) = br.readLine().split(' ').map { it.toInt() }
        points[it][0] = x
        points[it][1] = y
    }

    if(points[0][0] == points[1][0])
        sb.append(points[2][0])
    else if(points[1][0] == points[2][0])
        sb.append(points[0][0])
    else if(points[2][0] == points[0][0])
        sb.append(points[1][0])

    sb.append(" ")

    if(points[0][1] == points[1][1])
        sb.append(points[2][1])
    else if(points[1][1] == points[2][1])
        sb.append(points[0][1])
    else if(points[2][1] == points[0][1])
        sb.append(points[1][1])

    print(sb)

}
