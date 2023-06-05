package baekjoon._3003

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val st = StringTokenizer(br.readLine())

    val numberOfVariety = 6
    val found : Array<Int> = Array<Int>(numberOfVariety) { 0 }
    val correct : Array<Int> = arrayOf(1,1,2,2,2,8)

    var foundIndex = 0
    while(st.hasMoreTokens()){
        found[foundIndex] = st.nextToken().toInt()
        sb.append(correct[foundIndex] - found[foundIndex]).append(" ")
        foundIndex++
    }
    sb.deleteCharAt(sb.lastIndex)

    print(sb)

}

/*
0 1 2 2 2 7 A
1 0 0 0 0 1 B
1 1 2 2 2 8 C
A + B = C
B = C - A

 2 1 2 1 2 1
-1 0 0 1 0 7
 1 1 2 2 2 8
 */