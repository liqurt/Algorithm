package baekjoon._24511

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() } // 0은 큐, 1은 스택
    val b = br.readLine().split(" ").map { it.toInt() }.toMutableList() // a에 들어가있는 원소들
    val m = br.readLine().toInt()
    val c = br.readLine().split(" ").map { it.toInt() }

    val result = mutableListOf<Int>()

    repeat(m) {outerIndex ->
        val cItem = c[outerIndex]
        var outItem : Int = -1
        var inItem : Int
        repeat(n) {innerIndex ->
            if(a[innerIndex] == 0){ // 큐
                //처음 자료구조
                if(innerIndex == 0){
                    outItem = b[innerIndex]
                    b[innerIndex] = cItem
                }
                //중간 자료구조
                else if(a[innerIndex-1] == 0){
                    inItem = outItem
                    outItem = b[innerIndex]
                    b[innerIndex] = inItem
                }
                //끝 자료구조
                else if(innerIndex == n-1){
                    result.add(b[innerIndex])
                    b[innerIndex] = outItem
                }
            }else{ // 스택
                //처음 자료구조
                if(innerIndex == 0){
                    outItem = cItem
                }
                //끝 자료구조
                else if(innerIndex == n-1){
                    result.add(outItem)
                }
            }
        }
    }

    repeat(m){
        sb.append(result[it]).append(" ")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}