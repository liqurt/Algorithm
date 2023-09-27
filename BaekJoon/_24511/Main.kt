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

/* initOutItem==1
* Q2Q3 -> [1,2] 3
* Q2S3 -> [1,3] 2
* S2Q3 -> [2,1] 3
* S2S3 -> [2,3] 1
*
* cItem은 첫 Q에 들어간다. 만일 Q가 없으면, 그냥 밖으로 나온다.
* Q에서 나온 Item은, 그 다음에 만나는 첫 Q로 들어간다. 그런게 없으면 그냥 밖으로 나온다.
* 마지막 Q의 Item이 result에 들어간다.
* Q가 없다면 그냥 들어간게 나온다.
* */

/*
* Q S S Q
* 1 2 3 4
* 3
* 2 4 7
*
* */