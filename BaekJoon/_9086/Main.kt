package baekjoon._9086

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val T = br.readLine().toInt()

    repeat(T){
        val sentence = br.readLine()
        sb.append(sentence[0],sentence[sentence.lastIndex],"\n")
    }
    sb.deleteCharAt(sb.length-1)

    print(sb)
}