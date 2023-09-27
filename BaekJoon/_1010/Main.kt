package baekjoon._1010

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

val bridgeHashMap = HashMap<Pair<Int,Int> , Int>()
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()


    val t = br.readLine().toInt()
    repeat(t) { tc ->
        val (n,m) = br.readLine().split(" ").map { it.toInt() }
        val result = bridge(n,m)
        sb.append(result).append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}

fun bridge(n : Int,m : Int) : Int{
    if(n == 1){
        bridgeHashMap[Pair(n,m)] = m
        return m
    }
    else if(n == m){
        bridgeHashMap[Pair(n,m)] = 1
        return 1
    }else{
        var m2 = m-1
        var result = 0
        while(n-1 <= m2){
            result += bridge(n-1,m2)
            m2--
        }
        bridgeHashMap[Pair(n,m)] = result
        return result
    }
}
/*
* 1 1 = 1
* 1 2 = 2
* 1 3 = 3
* 1 4 = 4
* 2 2 = 1
* 2 3 = 2 + 1
* 2 4 = 3 + 2 + 1
* 2 5 = 4 + 3 + 2 + 1
* 3 3 = 1
* 3 4 = (2+1) + 1
* 3 5 = (3+2+1) + (2+1) + 1
* 4 4 = 1
* 4 5 = (2+1) + 1 + 1
* 4 6 = (3+2+1) + (2+1) + 1 + (2+1) + 1 + 1
*/