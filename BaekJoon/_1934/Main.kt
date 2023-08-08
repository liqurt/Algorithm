package baekjoon._1934

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.sqrt

class Main {
}

val MAX_NUM = 45000
val primeNumbersUnderMaxnum = bringPrimeNumbersUnderMaxnum()
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val T = br.readLine().toInt()

    repeat(T){
        val (A,B) = br.readLine().split(" ").map { it.toInt() }
        // a,b 각각 소인수분해
        // a의 해쉬, b의 해쉬를 합할것임 이를 c라고 한다.
        val aHashMap = factorization(A)
        val bHashMap = factorization(B)
        sb.append(aHashMap).append("\n").append(bHashMap).append("\n")
    // 1. a와 b둘다 같은 키가 있다면, 밸류는 큰 놈을 택함.

        // 2. 다른 키가 있다면, 그냥 택함.
        // 3. c의 키밸을 죄다 곱함.
    }
    print(sb)
}

fun bringPrimeNumbersUnderMaxnum(): ArrayList<Int> {
    val result = ArrayList<Int>()
    for(n in 2..MAX_NUM){
        val sqrtN = (sqrt(n.toDouble())).toInt()
        var isNSosu = true
        for(numberUnderSqrtN in 2..sqrtN){
            if(n%numberUnderSqrtN == 0){
                isNSosu = false
                break
            }
        }
        if(isNSosu){
            result.add(n)
        }
    }
    return result
}

fun factorization(n : Int): ArrayList<Int> {
    var primeNumbersIndex = 0
    var resultIndex = 0
    var target = n
    val result = ArrayList<Int>()
    while(true){
        val factor = primeNumbersUnderMaxnum[primeNumbersIndex]
        if(n % factor == 0){
            var jisu = 0
            while(true){
                target /= factor
                jisu++
                if(target%factor !=0){
                    result.add(resultIndex, factor)
                    resultIndex++
                    result.add(resultIndex, jisu)
                    resultIndex++
                    break
                }
            }
        }
        if(target == 1){
            break
        }
        primeNumbersIndex++
    }
    return result
}
