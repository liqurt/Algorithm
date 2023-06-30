package baekjoon._2783

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val A = Array(N) { IntArray(M) }
    val B = Array(N) { IntArray(M) }
    val C = Array(N) { IntArray(M) }

    var i: Int
    var j: Int

    repeat(2 * N) {
        j = 0
        st = StringTokenizer(br.readLine())
        if (it < N) {
            i = it
            while (st.hasMoreTokens()) {
                A[i][j] = st.nextToken().toInt()
                j++
            }
        } else {
            i = it - N
            while (st.hasMoreTokens()) {
                B[i][j] = st.nextToken().toInt()
                j++
            }
        }
    }

    repeat(N) { ii ->
        repeat(M) { jj ->
            C[ii][jj] = A[ii][jj] + B[ii][jj]
            sb.append(C[ii][jj]).append(" ")
        }
        sb.deleteCharAt(sb.lastIndex)
        sb.append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)

    print(sb)


}

//  4 3
//  1 1 1
//  2 2 2
//  0 1 0
//  2 2 2
//  3 3 3
//  4 4 4
//  5 5 100
//  2 2 2