package baekjoon._25192

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val msgList = mutableListOf<String>()

    val greeting = HashMap<String, Boolean>()

    var count = 0
    repeat(n) {
        val msg = br.readLine()
        msgList.add(msg)

        if (msg == "ENTER") {
            greeting.clear()
        } else if (!greeting.containsKey(msg)) {
            greeting[msg] = true
            count++
        }
    }

    sb.append(count)
    print(sb)
}