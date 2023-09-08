package baekjoon._11866

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val inputData = ArrayList<Int>()
    repeat(n){
        inputData.add(it+1)
    }
    sb.append('<').append(josephus(inputData,n, k)).deleteCharAt(1).deleteCharAt(sb.lastIndex).append('>')
    print(sb)
}

fun josephus(q: ArrayList<Int>, n : Int, k : Int): ArrayList<Int> {
    val result = ArrayList<Int>()
    val counted = ArrayList<Boolean>()
    repeat(n){
        counted.add(false)
    }

    var falseCount = 0
    var index = 0
    while(result.size < n){
        if(!counted[index]){
            falseCount++
            if(falseCount == k){
                falseCount = 0
                result.add(q[index])
                counted[index] = true
            }
        }
        index++
        if(n <= index){
            index = 0
        }
    }
    return result
}