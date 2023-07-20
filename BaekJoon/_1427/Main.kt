package baekjoon._1427

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val num = br.readLine().toCharArray()
    num.sortDescending()
    sb.append(num)
    print(sb)
}