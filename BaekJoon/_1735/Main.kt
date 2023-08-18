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

// 최소공배수
fun lcm(a : Int, b : Int) : Int{
    var absAB = a*b
    if(absAB < 0){
        absAB = -absAB
    }
    val result = (absAB / gcd(a,b)).toLong()
    return result.toInt()
}

// 약분
fun simplifyingFraction(a : Int, b : Int) : List<Int>{
    val gcd = gcd(a,b)
    val result = ArrayList<Int>(2)
    result.add(a/gcd)
    result.add(b/gcd)
    return result
}

// 분수 덧셈
fun addBothFractions(a: List<Int>, b: List<Int>): List<Int> {
    val denominator = lcm(a[1], b[1])
    val numerator = a[0] * (denominator / a[1]) + b[0] * (denominator / b[1]) // 괄호를 치지 않으면 큰 수끼리 곱셈할시 Overflow가 나서 Int로 표현하기 벅찰수가 있다. ex> 29999 30000\n 29998 39999
    return simplifyingFraction(numerator, denominator)
}
