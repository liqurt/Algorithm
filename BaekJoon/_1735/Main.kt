package baekjoon._1735

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val fraction1 = br.readLine().split(" ").map { it.toInt() }
    val fraction2 = br.readLine().split(" ").map { it.toInt() }

    val fraction3 = addBothFractions(fraction1, fraction2)

    sb.append(fraction3[0]).append(" ").append(fraction3[1])
    print(sb)
}

// 최대공약수
fun gcd(a : Int, b : Int) : Int{
    if(b == 0){
        return a
    }else{
        return gcd(b, a%b)
    }
}

// 약분
fun simplifyingFraction(numerator : Int, denominator : Int) : List<Int>{
    val gcd = gcd(numerator,denominator)
    val result = ArrayList<Int>(2)
    result.add(numerator/gcd)
    result.add(denominator/gcd)
    return result
}

// 분수 덧셈
fun addBothFractions(fraction1: List<Int>, fraction2: List<Int>): List<Int> {
    val denominator = fraction1[1] * fraction2[1]
    val numerator = fraction1[0] * fraction2[1] + fraction1[1] * fraction2[0]
    return simplifyingFraction(numerator, denominator)
}
