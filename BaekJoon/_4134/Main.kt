package baekjoon._4134

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.sqrt

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val t = br.readLine().toInt()

    repeat(t){
        val n = br.readLine().toUInt()
        val minPrimeOverN = findMinPrimeOverMe(n)
        sb.append(minPrimeOverN).append("\n")
    }

    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}

fun findMinPrimeOverMe(n : UInt) : UInt{
    var item = n
    while(true){
        if(isThisPrimeNumber(item)){
            return item
        }else{
            item++
        }
    }
}

fun isThisPrimeNumber(n : UInt) : Boolean{
    // 일단 0,1은 소수가 아님
    if(n == 0u || n == 1u){
        return false
    }

    // sqrt(n) 밑으로 쭉 나눠보기
    val firstCompositeNumUnder100 : UByte = 2u
    val sqrtN = sqrt(n.toDouble()).toUInt().toUShort()
    for(i in sqrtN downTo firstCompositeNumUnder100.toUShort() step(1)){
        if(n % i == 0u){
            return false
        }
    }

    return true
}