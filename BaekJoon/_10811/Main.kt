package baekjoon._10811

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Main {

}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val arr : Array<Int> = Array(N){i -> i+1}
    val M = st.nextToken().toInt()

    repeat(M){
        st = StringTokenizer(br.readLine())
        val i = st.nextToken().toInt()
        val j = st.nextToken().toInt()
        arr.reverse(i-1,j)
    }

    arr.forEach { sb.append(it).append(" ") }
    sb.deleteCharAt(sb.length-1)
    print(sb)

}

/*
N = 5
M = 4
init = 1 2 3 4 5
t1 = 2 1 3 4 5
t2 = 2 1 4 3 5
t3 = 3 4 1 2 5
t4 = 3 4 1 2 5
 */