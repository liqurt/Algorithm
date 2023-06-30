package baekjoon._1085

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val (x,y,w,h) = br.readLine().split(' ').map { it.toInt() }

    val north = h-y
    val east = w-x
    val south = y
    val west = x

    var minDistance = 9999
    if(north < minDistance)
        minDistance = north
    if(east < minDistance)
        minDistance = east
    if(south < minDistance)
        minDistance = south
    if(west < minDistance)
        minDistance = west

    sb.append(minDistance)
    print(minDistance)
}