package baekjoon._10816

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val numCards = Array<Int>(20000001){0}
    val cards = StringTokenizer(br.readLine()," ")
    repeat(n){
        numCards[cards.nextToken().toInt()+10000000]++
    }
    val m = br.readLine().toInt()
    val myCards = StringTokenizer(br.readLine()," ")
    repeat(m){
        sb.append(numCards[myCards.nextToken().toInt()+10000000]).append(" ")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}