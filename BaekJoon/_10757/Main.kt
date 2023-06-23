package baekjoon._10757

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val st = StringTokenizer(br.readLine())

    val a = st.nextToken().toBigDecimal()
    val b = st.nextToken().toBigDecimal()
    val answer = a+b
    sb.append(answer)
    print(sb)
}