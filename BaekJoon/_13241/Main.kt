package baekjoon._13241

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer
import kotlin.math.abs

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val st = StringTokenizer(br.readLine())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()

    val gcdAB = gcd(a,b)
    val absAB = abs(a*b)
    val lcdAB = absAB/gcdAB

    sb.append(lcdAB)
    print(sb)
}

fun gcd(a : Long, b : Long): Long {
    return if(b == 0L){
        a
    }else {
        gcd(b , a%b)
    }
}

