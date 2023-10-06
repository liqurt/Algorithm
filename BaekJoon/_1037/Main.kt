package baekjoon._1037

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val yaksuList = mutableListOf<Int>()
    val st = StringTokenizer(br.readLine())
    while(st.hasMoreTokens()){
        yaksuList.add(st.nextToken().toInt())
    }
    yaksuList.sort()

    var result = -1
    if(yaksuList.size == 1){
        result = yaksuList[0] * yaksuList[0]
    }else{
        result = yaksuList[0] * yaksuList[yaksuList.size-1]
    }
    sb.append(result)
    print(sb)

}