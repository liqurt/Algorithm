package baekjoon._17103

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.sqrt

class Main {
}

val MAX_NUM = 1000000
lateinit var primeUnderMaxNum : MutableList<Int>
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    setPrimeUnderMaxNum()

    val t = br.readLine().toInt()

    repeat(t){
        val n = br.readLine().toInt()
        val count : Int = countGoldbachPartition(n)
        sb.append(count).append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)

}

fun countGoldbachPartition(n: Int): Int {
    val primesUnderN = getPrimeUnderN(n)

    // 양쪽에서 시작해 중앙으로 오면서 더한다
    var l = 0
    var r = primesUnderN.lastIndex
    var count = 0
    while(l <= r){
        val sum = primesUnderN[l] + primesUnderN[r]
        if(sum == n){
            count++
            l++
            r--
        }else if(sum < n){
            l++
        }else{
            r--
        }
    }

    return count
}

// n의 lowerBound를 찾는다.
fun getPrimeUnderN(n: Int): List<Int> {
    // n의 lower bound 찾기
    var L = 0
    var R = primeUnderMaxNum.lastIndex
    while(L < R){
        val M = (L+R) / 2
        val midValue = primeUnderMaxNum[M]
        if(n < midValue){
            R = M
        }else{
            L = M+1
        }
    }

    // 자신을 끼면 당연히 덧셈으로 자신이 나올수 없음
    val result = primeUnderMaxNum.subList(0,L)
    if(result.contains(n)){
        result.removeAt(result.lastIndex)
    }
    return result
}

fun setPrimeUnderMaxNum() {
    primeUnderMaxNum = mutableListOf()
    for(i in 2..MAX_NUM){
        if(isThisPrime(i)){
            primeUnderMaxNum.add(i)
        }
    }
}

fun isThisPrime(n : Int) : Boolean{
    if(n <= 1) return false
    val sqrtN = sqrt(n.toDouble()).toInt()
    for(i in 2..sqrtN){
        if(n % i == 0){
            return false
        }
    }
    return true
}