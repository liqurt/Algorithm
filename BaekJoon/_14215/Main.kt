package baekjoon._14215

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val st = StringTokenizer(br.readLine())
    val lines = MutableList<Int>(3){i -> -1}
    var i=0
    while(i<3){
        lines[i] = st.nextToken().toInt()
        i++
    }
    lines.sort()

    if(!isThisTriangle(lines)){
        lines[2] = lines[0] + lines[1] - 1
    }
    sb.append(lines.sum())
    print(sb)
    /*
    * 삼각형 체크 : 맥스는 맥스가 아닌 변들의 합보다 작아야만 한다.
    * 1. 삼각형 체크
    * Y - ㄱㄱ
    * N - 맥스를 줄인다.
    * 2. 다시 삼각형 체크
    * */
}

fun isThisTriangle(lines : List<Int>) : Boolean{
    return lines.max() < lines.sum()-lines.max()
}