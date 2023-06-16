package baekjoon._2745

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer
import kotlin.math.pow

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val st = StringTokenizer(br.readLine())
    val N = st.nextToken()
    val B = st.nextToken().toInt()

    var D = 0

        repeat(N.length) {
            val V = if(N[it].code<58){
                N[it].code - 48
            }else{
                N[it].code - 55
            }

            val U = N.length - it - 1
            val T = B.toDouble().pow(U.toDouble()).toInt()
            D += V * T

//            println("D($D) = V($V) * B($B)* U($U) // T is ($T)")
        }
    sb.append(D)
    print(sb)

}