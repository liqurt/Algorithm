package baekjoon._10988

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val word = br.readLine()
    val reversedWord = word.reversed()

    if(word.equals(reversedWord)){
        sb.append(1)
    }else{
        sb.append(0)
    }

    print(sb)
}