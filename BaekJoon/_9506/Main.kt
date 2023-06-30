package baekjoon._9506

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    while (true) {
        val n = br.readLine().toInt()
        if (n == -1) {
            sb.deleteCharAt(sb.lastIndex)
            break
        } else {
            var nowNumber = 0
            var sum = 0
            val yaksuList = ArrayList<Int>()
            // 완전수 체크
            while (true) {
                nowNumber++
                if (n <= nowNumber) {
                    break
                }
                if (n % nowNumber == 0) {
                    sum += nowNumber
                    yaksuList.add(nowNumber)
                }
            }
            if (sum == n) {
                sb.append(n).append(" = ")
                repeat(yaksuList.size-1) {
                    sb.append(yaksuList[it]).append(" + ")
                }
                sb.append(yaksuList[yaksuList.size-1])
                sb.append("\n")
            } else {
                sb.append(n).append(" is NOT perfect.\n")
            }
        }
    }

    print(sb)
}