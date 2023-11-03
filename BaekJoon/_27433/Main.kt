package baekjoon._27433

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toLong()
    val result = factorial(n)
    sb.append(result)
    print(sb)
}

fun factorial(n : Long) : Long{
    return if(n == 0L)
        1
    else{
        n * factorial(n-1)
    }
}