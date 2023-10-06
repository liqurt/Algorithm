package baekjoon._26069

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val rainbowDancer = hashSetOf<String>()
    rainbowDancer.add("ChongChong")

    var chongChongIsHere = false
    repeat(n){
        val log = br.readLine().split(" ")
        if(log.contains("ChongChong")){
            chongChongIsHere = true
        }
        if(chongChongIsHere){
            if(rainbowDancer.contains(log[0])){
                rainbowDancer.add(log[1])
            }else if(rainbowDancer.contains(log[1])){
                rainbowDancer.add(log[0])
            }
        }
    }
    sb.append(rainbowDancer.size)
    print(sb)
}