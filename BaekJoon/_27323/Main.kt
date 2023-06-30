package baekjoon._27323

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val A = br.readLine().toInt()
    val B = br.readLine().toInt()

    val C = A*B

    sb.append(C)
    print(sb)
}