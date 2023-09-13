package baekjoon._2346

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.abs
import kotlin.text.StringBuilder

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val balloons = ArrayDeque<Balloon>()
    val st = StringTokenizer(br.readLine())
    var i=1
    while (st.hasMoreTokens()) {
        val item = st.nextToken().toInt()
        balloons.addLast(Balloon(item, i))
        i++
    }

    val result = chainPop(balloons, n)
    print(result)

}

fun chainPop(balloons: ArrayDeque<Balloon>, n: Int): String {
    val sb = StringBuilder()
    var paper = balloons.removeFirst().paper
    sb.append(1).append(" ")

    while (balloons.isNotEmpty()) {
        var poppedBalloonPaper: Int
        var poppedBalloonIndex: Int
        if (0 < paper) {
            repeat(paper - 1) {
                balloons.addLast(balloons.removeFirst()) // 앞의 것을 뒤로
            }
            poppedBalloonPaper = balloons.first().paper
            poppedBalloonIndex = balloons.removeFirst().index
        } else {
            repeat(abs(paper) - 1) {
                balloons.addFirst(balloons.removeLast()) // 뒤의 것을 앞으로
            }
            poppedBalloonPaper = balloons.last().paper
            poppedBalloonIndex = balloons.removeLast().index
        }
        paper = poppedBalloonPaper
        sb.append(poppedBalloonIndex).append(" ")
    }
    sb.deleteCharAt(sb.lastIndex)

    return sb.toString()
}

data class Balloon(
    val paper: Int,
    val index: Int
)
