package baekjoon._2587

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val nums = Array<Int>(5){i -> -1}
    repeat(5){
        nums[it] = br.readLine().toInt()
    }

    val avg = nums.average()
    nums.sort()
    val mid = nums[nums.size/2]
    sb.append(avg.toInt()).append("\n").append(mid)
    print(sb)
}