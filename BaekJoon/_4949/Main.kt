package baekjoon._4949

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    while (true) {
        val sentence = br.readLine()
        if (sentence == ".")
            break
        if (isThisVPS(sentence))
            sb.append("yes").append("\n")
        else
            sb.append("no").append("\n")
    }

    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}

fun isThisVPS(sentence: String): Boolean {
    val line = sentence.toCharArray()
    val gwalho = Stack<Char>()
    for (i in line.indices) {
        val item = line[i]
        when (item) {
            '(', '[' -> {
                gwalho.push(item)
            }

            ')', ']' -> {
                if (gwalho.isEmpty()) { // 여는 괄호도 없이 닫는 괄호가 먼저 나오면,
                    return false
                }

                // 매치가 된다면, 다음 단어를 살핀다.
                // 매치가 안된다면, VPS가 아님.
                val prevItem = gwalho.pop()
                if (!match(prevItem, item)) {
                    return false
                }
            }
        }
    }
    return gwalho.isEmpty() // 아직 열린 괄호가 남아있다면 false
}

fun match(item1: Char, item2: Char): Boolean {
    when (item1) {
        '(' -> {
            if (item2 == ')') {
                return true
            }
        }

        '[' -> {
            if (item2 == ']') {
                return true
            }
        }
    }
    return false
}