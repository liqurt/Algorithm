package baekjoon._10101

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val angles = MutableList<Int>(3) { i -> -1 }
    var loopCount = 0
    while(loopCount < 3){
        angles[loopCount] = br.readLine().toInt()
        loopCount++
    }

    if(angles.sum() != 180){
        sb.append("Error")
    }
    else{
        if(angles[0] == 60 && angles[1] == 60 && angles[2] == 60){
            sb.append("Equilateral")
        }
        else if(angles[0] == angles[1] || angles[1] == angles[2] || angles[0] == angles[2]){
            sb.append("Isosceles")
        }
        else{
            sb.append("Scalene")
        }
    }

    print(sb)
}