package baekjoon._18870

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val OVERNUMBER = 1000001
    val n = br.readLine().toInt()
    val originalXarr = Array<Int>(n){0}
    val st = StringTokenizer(br.readLine())
    while(st.hasMoreTokens()){
        originalXarr[n-st.countTokens()] = st.nextToken().toInt()
    }

    // 7
    // 9 2 2 -3 7 -3 -3

    // pre option
    // c = 0
    // originalArr, compressedArr

    /*
    1. 오리지널 어레이에서 최소값을 찾는다.
    2. 최소값을 가진 모든 인덱스를 찾는다.
    3. 압축 어레이의 해당 인덱스에 c 값을 넣는다.
    4. c++
    5. 오리지널 어레이의 해당 인덱스에는 overnumber 값을 넣는다.
    6. 오리지널 어레이의 모든 값이 overnumber가 될 때 까지 반복
     */

    var c = 0
    val compressedXarr = Array<Int>(n){0}

    while(originalXarr.min() != OVERNUMBER){
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