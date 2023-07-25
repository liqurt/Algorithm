package baekjoon._18870

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

class Main {
}

fun main(){
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val originalXarr = Array<Int>(n){0}
    val st = StringTokenizer(br.readLine())
    while(st.hasMoreTokens()){
        originalXarr[n-st.countTokens()] = st.nextToken().toInt()
    }
    val compressedXarr = Array<Int>(n){0}

    // 시간초과된 첫번쨰 방법
    val OVERNUMBER = 1000001
    var c = 0
    while(originalXarr.min() != OVERNUMBER){ //O(n) = n, 밑에 꺼 포함하면 O(n) = n^2
        val min = originalXarr.min()
        val minIndexStack = Stack<Int>()
        for (i in 0 until n){ // O(n) = n
            if(originalXarr[i] == min){
                minIndexStack.push(i)
            }
        }
        for (i in 0 until minIndexStack.size){ // O(n) = stack.size
            val minIndex = minIndexStack.pop()
            compressedXarr[minIndex] = c
            originalXarr[minIndex] = OVERNUMBER
        }
        c++
    }

    for (i in 0 until n){
        sb.append(compressedXarr[i]).append(" ")
    }
    sb.deleteCharAt(sb.length-1)
    print(sb)
}

data class Point(
    val originalIndex : Int,
    val originalValue : Int,
    val compressIndex : Int,
    val compressValue : Int
)