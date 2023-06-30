package baekjoon._15894

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val answer : Long = n.toLong() * 4.toLong()
    sb.append(answer)
    print(sb)
}