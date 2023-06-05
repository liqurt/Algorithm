package baekjoon._27866

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val S = br.readLine()
    val i = br.readLine().toInt()

    sb.append(S[i-1])
    print(sb)
}

