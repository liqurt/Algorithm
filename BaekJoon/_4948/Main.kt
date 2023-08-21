package baekjoon._4948

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.sqrt

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    while(true){
        val n = br.readLine().toInt()
        if(n == 0){
            break
        }
        var primeCount = 0
        for(i in n+1 .. 2*n){
            if(isThisPrime(i)){
                primeCount++
            }
        }
        sb.append(primeCount).append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}

fun isThisPrime(n : Int) : Boolean{
    if(n == 1) return false
    val sqrtN = sqrt(n.toDouble()).toInt()
    for(i in 2 .. sqrtN){
        if(n % i == 0){
            return false
        }
    }
    return true
}