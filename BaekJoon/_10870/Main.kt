package baekjoon._10870

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val result = fibo(n)
    sb.append(result)
    print(result)
}

fun fibo(n : Int) : Int{
    return if(n == 0)
        0
    else if (n == 1)
        1
    else{
        fibo(n-1) + fibo(n-2)
    }
}