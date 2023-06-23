package baekjoon._2869

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer
import kotlin.math.ceil

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val st = StringTokenizer(br.readLine()," ")

    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val v = st.nextToken().toInt()

    val day1 = ceil(v.toDouble() / (a-b).toDouble()).toInt()

    var day2 = ceil((v-a).toDouble() / (a-b).toDouble()).toInt()
    if(v <= day2 * (a-b) + a){
        day2 += 1
    }

    if(day2 < day1){
        sb.append(day2)
    }else{
        sb.append(day1)
    }
    print(sb)
}