package baekjoon._2751

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()

    val nums = Array<Int>(n){-1}

    var i = 0
    while(i<n){
        nums[i] = br.readLine().toInt()
        i++
    }
    nums.sort()

    i = 0
    while(i<n){
        sb.append(nums[i]).append("\n")
        i++
    }

    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}