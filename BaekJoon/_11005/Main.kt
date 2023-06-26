package baekjoon._11005

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val st = StringTokenizer(br.readLine())
    var N = st.nextToken().toInt()
    val B = st.nextToken().toInt()

    val list = ArrayList<Int>()

    while(true){
        if(N <= 0)
            break
        val namuzi = N % B
        N -= namuzi
        N /= B
        list.add(namuzi)
    }
    list.reverse()

    repeat(list.size){
        if(9<list[it]){
            val v = (list[it].toChar().code + 55).toChar()
            sb.append(v)
        }else{
            val v = list[it]
            sb.append(v)
        }
    }
    print(sb)
    print(list)
}

// 29479127 34 - M20X5