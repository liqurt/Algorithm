package baekjoon._1764

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*


class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val neverHeardAndSeen = TreeMap<String, String>()
    val neverHeard = mutableSetOf<String>()
    repeat(n){
        val name = br.readLine()
        neverHeard.add(name)
    }
    repeat(m){
        val name = br.readLine()
        if(neverHeard.contains(name)){
            neverHeardAndSeen.put(name,name)
        }
    }
    sb.append(neverHeardAndSeen.size).append("\n")

    val iter = neverHeardAndSeen.iterator()
    while(iter.hasNext()){
        sb.append(iter.next().value).append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}