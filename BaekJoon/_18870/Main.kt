package baekjoon._18870

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

class Main {
}

fun main(){ //아직도 시간초과
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val pointArr = Array(n){Point()}
    val st = StringTokenizer(br.readLine())
    while(st.hasMoreTokens()){
        val i = n-st.countTokens()
        pointArr[i].apply {
            originalIndex = i
            originalValue = st.nextToken().toInt()
        }
    }

    pointArr.sortBy { it.originalValue }
    var c = 0
    var ci = 1

    while(ci < n){ // O(n) = n 이 아닌가..?
        if(pointArr[ci-1].originalValue != pointArr[ci].originalValue){
            c++
        }
        pointArr[ci].compressIndex = ci
        pointArr[ci].compressValue = c
        ci++
    }

    pointArr.sortBy { it.originalIndex }

    for(i in 0 until n){
        sb.append(pointArr[i].compressValue).append(" ")
    }
    sb.deleteCharAt(sb.length-1)
    print(sb)
}

data class Point(
    var originalIndex : Int = 0,
    var originalValue : Int = 0,
    var compressIndex : Int = 0,
    var compressValue : Int = 0
)

/*
1. 정렬
2. c=0, ci=0
3. 맨 왼쪽에 c 값 넣기
4. ci++

LOOP
5. pA[ci] 값이 pA[ci-1]과 같은가?
5-1. 같음 : pA[ci] = c
5-2. 다름 : pA[ci] = ++c
6. ci++
7. n <= ci 이면, 루프 끝
 */
