package baekjoon._10816

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine()," ")
    val numCards = HashMap<Int, Int>()
    while(st.hasMoreTokens()){
        val num = st.nextToken().toInt()
        if(!numCards.containsKey(num)){
            numCards[num] = 1
        }else{
            numCards[num] = numCards[num]!! + 1
        }
    }
    val m = br.readLine().toInt()
    val st2 = StringTokenizer(br.readLine()," ")
    while(st2.hasMoreTokens()){
        val num = st2.nextToken().toInt()
        if(numCards.containsKey(num)){
            sb.append(numCards[num]).append(" ")
        }
        else{
            sb.append(0).append(" ")
        }
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}