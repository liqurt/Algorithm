package baekjoon._1010

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

val bridgeHash = HashMap<Pair<Int,Int>, Int>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()


    val t = br.readLine().toInt()
    repeat(t) { tc ->
        val (n,m) = br.readLine().split(" ").map { it.toInt() }
        sb.append(bridge(n,m)).append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}

fun bridge(n : Int, m : Int) : Int{
    var result = -1
    val candidate = Pair(n,m)
    if(bridgeHash.containsKey(candidate)){
        return bridgeHash[candidate]!!
    }else{
        result = if(n == 1){
            m
        }else if(n == m){
            1
        }else{
            bridge(n,m-1) + bridge(n-1,m-1)
        }
        bridgeHash[candidate] = result
    }
    addResultToHash(n,m,result)
    return result
}


fun addResultToHash(n : Int, m : Int, result : Int){
    val candidate = Pair(n,m)
    if(!bridgeHash.containsKey(candidate)){
        bridgeHash[candidate] = result
    }
}