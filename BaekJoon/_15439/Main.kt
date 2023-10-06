package baekjoon._15439

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val result = n*n-n
    print(result)
}