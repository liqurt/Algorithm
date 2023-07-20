package baekjoon._11650

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val pointArray = Array<Point>(n){i -> Point(0,0)}
    repeat(n){
        val (xi,yi) = br.readLine().split(" ").map { it.toInt() }
        val pi = Point(xi,yi)
        pointArray[it] = pi
    }


}

data class Point(
    val x : Int,
    val y : Int
)