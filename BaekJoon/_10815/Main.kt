package baekjoon._10815

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.HashMap
import java.util.StringTokenizer

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val maxN = 500000

    // 입력
    val n = br.readLine().toInt()
    var st = StringTokenizer(br.readLine())
    val numCards = Array<Int>(n){i -> 0}
    var numCardsIndex = 0
    while(st.hasMoreTokens()){
        numCards[numCardsIndex] = st.nextToken().toInt()
        numCardsIndex++
    }
    val m = br.readLine().toInt()
    st = StringTokenizer(br.readLine())
    val sangunNumCards = Array<Int>(m){i -> 0}
    var sangunNumCardsIndex = 0
    while(st.hasMoreTokens()){
        sangunNumCards[sangunNumCardsIndex] = st.nextToken().toInt()
        sangunNumCardsIndex++
    }

    val numCardsHashMap = HashMap<Int, Int>(n)
    for(i in 0 until n){
        numCardsHashMap[numCards[i]] = 1
    }

    for(i in 0 until m){
        val z = sangunNumCards[i]
        if(numCardsHashMap.containsKey(z)){
            sb.append("1")
        }else{
            sb.append("0")
        }
        sb.append(" ")
    }
    print(sb)

    /*
    * 1. numCards로 해시맵 만듬
    * 2. 상근numCards로 루프 돌림
    * 2-1.   상근의 카드번호로 numCards 해시맵 탐방
    * */
}