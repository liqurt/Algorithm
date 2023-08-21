package baekjoon._1929

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.sqrt

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val (m, n) = br.readLine().split(" ").map { it.toInt() }

    for(i in m .. n){
        if(isThisPrime(i)){
            sb.append(i).append("\n")
        }
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}

fun isThisPrime(num : Int) : Boolean{
    if(num == 1)
        return false
    val sqrtN = sqrt(num.toDouble()).toInt()
    for(i in 2 .. sqrtN){
        if(num % i == 0){
            return false
        }
    }
    return true
}