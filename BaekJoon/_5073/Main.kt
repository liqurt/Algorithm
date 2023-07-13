package baekjoon._5073

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    while (true) {
        val st = StringTokenizer(br.readLine())
        val lines = List<Int>(3){ i -> -1}.toMutableList()
        var i = 0
        while(i<3){
            lines[i] = st.nextToken().toInt()
            i++
        }
        if (lines.sum() == 0) {
            break
        } else {
            if (lines.max() >= lines.sum() - lines.max()) {
                sb.append("Invalid")
            } else {
                if (lines[0] == lines[1] && lines[1] == lines[2]) {
                    sb.append("Equilateral")
                } else if (lines[0] == lines[1] || lines[0] == lines[2] || lines[1] == lines[2]) {
                    sb.append("Isosceles")
                } else if (lines[0] != lines[1] && lines[1] != lines[2] && lines[0] != lines[2]) {
                    sb.append("Scalene")
                }
            }
            sb.append("\n")
        }
    }
    sb.deleteCharAt(sb.length-1)
    print(sb)
}