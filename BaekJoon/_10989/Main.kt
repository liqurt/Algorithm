package baekjoon._10989

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val nums = MutableList<Int>(10001) { 0 }

    repeat(n) {
        val num = br.readLine().toInt()
        nums[num]++
    }

    for(loopIndex in 1..10000){
        if(0 <= nums[loopIndex]){
            repeat(nums[loopIndex]){
                sb.append(loopIndex).append("\n")
            }
        }
    }

    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}