package baekjoon._2444

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val N = br.readLine().toInt()

    var i = -1
    repeat((2*N)-1){
        if(it <= N-1){
            i = it
        }
        if(N-1<it){
            i = N-1-(it-(N-1))
        }
        repeat((N-1) - i){
            sb.append(" ")
        }
        repeat(1+(2*i)){
            sb.append("*")
        }
        sb.append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}