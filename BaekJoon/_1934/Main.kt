package baekjoon._1934

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.pow
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
        val aFactors = factorization(A)
        val bFactors = factorization(B)

        val cFactors = HashMap<Int, Int>()
        val aFactorsIter = aFactors.iterator()
        while(aFactorsIter.hasNext()){ // 일단 a를 c에 담고
            val item = aFactorsIter.next()
            cFactors[item.key] = item.value
        }

        val bFactorsIter = bFactors.iterator()
        while(bFactorsIter.hasNext()){ // b도 c에 담는다
            val item = bFactorsIter.next()
            if(cFactors.containsKey(item.key)){ // 근데 밑이 같은게 오면
                if(cFactors[item.key]!! < item.value){ // 지수가 큰 걸 갖고옴
                    cFactors[item.key] = item.value
                }
            }else{
                cFactors[item.key] = item.value
            }
        }
        var result = 1
        val cFactorsIter = cFactors.iterator()
        while(cFactorsIter.hasNext()){
            val item = cFactorsIter.next()
            result *= item.key.toDouble().pow(item.value.toDouble()).toInt()
        }
        sb.append("$result\n")
    }
    sb.deleteCharAt(sb.length-1)
    print(sb)
}

// 45000 이하의 소수
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

// 소인수분해
fun factorization(n : Int): HashMap<Int,Int> {
    var primeNumbersIndex = 0
    var resultIndex = 0
    var target = n
    val result = HashMap<Int,Int>()
    while(true){
        val factor = primeNumbersUnderMaxnum[primeNumbersIndex]
        if(n % factor == 0){
            var jisu = 0
            while(true){
                target /= factor
                jisu++
                if(target%factor !=0){
                    result[factor] = jisu
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
