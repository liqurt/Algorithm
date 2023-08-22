package baekjoon._10773

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val k = br.readLine().toInt()
    val jangbu = Stack<Int>()
    repeat(k){
        val n = br.readLine().toInt()
        if(n == 0){
            jangbu.pop()
        }else{
            jangbu.push(n)
        }
    }

    var sum =0
    while(!jangbu.empty()){
        val item = jangbu.pop()
        sum += item
    }

    sb.append(sum)
    print(sb)
}