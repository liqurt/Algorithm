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

    // x기준 정렬
    for(i in 0 until n){
        for(j in i+1 until n){
            if(pointArray[j].x < pointArray[i].x){
                val temp = pointArray[i]
                pointArray[i] = pointArray[j]
                pointArray[j] = temp
            }
        }
    }

    // y기준 정렬
    for(i in 0 until n){
        for(j in i+1 until n){
            if(pointArray[i].x == pointArray[j].x){
                if(pointArray[j].y < pointArray[i].y){
                    val temp = pointArray[i]
                    pointArray[i] = pointArray[j]
                    pointArray[j] = temp
                }
            }
        }
    }

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