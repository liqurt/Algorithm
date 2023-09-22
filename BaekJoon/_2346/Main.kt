package baekjoon._2346

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.collections.ArrayDeque
import kotlin.math.abs
import kotlin.text.StringBuilder

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val balloons = ArrayDeque<Balloon>(initialCapacity = n)
    val st = StringTokenizer(br.readLine())
    var i=1
    while (st.hasMoreTokens()) {
        val item = st.nextToken().toInt()
        balloons.addLast(Balloon(item, i))
        i++
    }

    val result = chainPop(balloons)
    repeat(n){
        sb.append(result[it]).append(" ")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)

}

fun chainPop(balloons: ArrayDeque<Balloon>): List<Int> {
    val result = mutableListOf<Int>()
    result.add(1) // 항상 1부터 터짐

    var paper = balloons.removeFirst().paper

    while (balloons.isNotEmpty()) {
        if (0 < paper) {
            repeat(paper - 1) {
                balloons.addLast(balloons.removeFirst()) // 앞의 것을 뒤로
            }
            paper = balloons.first().paper
            result.add(balloons.removeFirst().index)
        } else {
            repeat(abs(paper) - 1) {
                balloons.addFirst(balloons.removeLast()) // 뒤의 것을 앞으로
            }
            paper = balloons.last().paper
            result.add(balloons.removeLast().index)
        }
    }
    return result
}

data class Balloon(
    val paper: Int,
    val index: Int
)
