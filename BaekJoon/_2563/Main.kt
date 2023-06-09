package baekjoon._2563

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

class Main {
}

fun main() {
    val GRID_SIZE = 100
    val PAPER_SIZE = 10
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val numberOfPaper = br.readLine().toInt()
    val grid = Array(GRID_SIZE) { Array<Boolean>(GRID_SIZE) { false } }

    var countBlack = 0

    repeat(numberOfPaper) {
        val st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        var i = x
        var j = y

        while (i < x+PAPER_SIZE) {
            j=y
            while (j < y+PAPER_SIZE) {
                if(!grid[i][j]){
                    grid[i][j] = true
                    countBlack++
                }
                j++
            }
            i++
        }
    }

    print(countBlack)

}