package baekjoon._25305

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val (n,k) = br.readLine().split(" ").map { it.toInt() }
    val scores = Array<Int>(n){-1}

    val st = StringTokenizer(br.readLine())
    while(st.hasMoreTokens()){
        scores[n-st.countTokens()] = st.nextToken().toInt()
    }

    scores.sort()
    sb.append(scores[n-k])
    print(sb)
}