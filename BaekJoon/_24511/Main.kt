package baekjoon._24511

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() } // 0은 큐, 1은 스택
    val b = br.readLine().split(" ").map { it.toInt() }.toMutableList() // a에 들어가있는 원소들
    val m = br.readLine().toInt()
    val c = br.readLine().split(" ").map { it.toInt() }

    val result = mutableListOf<Int>()


    val q = ArrayDeque<Int>()
    repeat(n){ qsIndex ->
        if(a[qsIndex] == 0){
            q.addLast(b[qsIndex])
        }
    }

    repeat(m) {inputIndex ->
        val outItem = c[inputIndex]
        q.addFirst(outItem)
        result.add(q.removeLast())
    }

    repeat(m){
        sb.append(result[it]).append(" ")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}