package baekjoon._9063

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val okBeads = Array(n){IntArray(2)}

    var north = -10001
    var east = -10001
    var south = 10001
    var west = 10001

    repeat(n){
        val (x,y) = br.readLine().split(' ').map { it.toInt() }
        okBeads[it][0] = x
        okBeads[it][1] = y

        if(north < y)
            north = y
        if(y < south)
            south = y
        if(east < x)
            east = x
        if(x < west)
            west = x
    }

    val answer = (east-west)*(north-south)
    sb.append(answer)
    print(sb)
}