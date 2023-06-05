package baekjoon._2566

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val gridSize = 9
    val grid = Array(gridSize){IntArray(gridSize){0} }
    var st: StringTokenizer

    var j: Int

    var maxNum = -1
    var maxI : Int = -1
    var maxJ : Int = -1

    repeat(gridSize){i->
        j = 0
        st = StringTokenizer(br.readLine())
        while(st.hasMoreTokens()){
            grid[i][j] = st.nextToken().toInt()
            if(maxNum < grid[i][j]){
                maxNum = grid[i][j]
                maxI = i+1
                maxJ = j+1
            }
            j++
        }
    }

    sb.append(maxNum).append("\n").append(maxI).append(" ").append(maxJ)
    print(sb)
}