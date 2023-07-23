package baekjoon._11651

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val pointArray = Array<Point>(n){i -> Point(0,0)}
    repeat(n){ it ->
        val (xi,yi) = br.readLine().split(" ").map { it.toInt() }
        val pi = Point(xi,yi)
        pointArray[it] = pi
    }

    pointArray.sortWith(compareBy<Point> {it.y}.thenBy {it.x})

    // 출력
    for(i in 0 until n){
        sb.append(pointArray[i].x).append(" ").append(pointArray[i].y).append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}

data class Point(
    val x : Int,
    val y : Int
)