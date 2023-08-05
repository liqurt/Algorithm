package baekjoon._11478

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val s = br.readLine()

    var L = 0
    var R = 1
    var step = 0
    val subStringSet = mutableSetOf<String>()
    while (step <= s.length){
        while(R <= s.length){
            subStringSet.add(s.substring(L,R))
            L++
            R++
        }
        step++
        L = 0
        R = step
    }
    sb.append(subStringSet.size)
    print(sb)
}