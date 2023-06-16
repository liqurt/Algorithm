package baekjoon._2720

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val T = br.readLine().toInt()

    val Q = 25
    val D = 10
    val N = 5
    val P = 1

    val coins = intArrayOf(Q, D, N, P)
    repeat(T) {
        var C = br.readLine().toInt() // 1달러 = 100센트
        repeat(coins.size) {
            sb.append(C/coins[it]).append(" ")
            C%=coins[it]
        }
        sb.deleteCharAt(sb.length-1).append("\n")
    }
    sb.deleteCharAt(sb.length-1)
    print(sb)
}