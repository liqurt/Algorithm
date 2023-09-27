package baekjoon._10872

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
    print(sb)
}

fun fibo(n : Int) : Int{
    return if(n <= 1){
        1
    }
    else{
        n * fibo(n-1)
    }
}
