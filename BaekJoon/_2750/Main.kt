package baekjoon._2750

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val nums = List<Int>(n){ i->0}.toMutableList()
    for(i in 0 until n){
        nums[0] = br.readLine().toInt()
    }
    nums.sort()

    for(i in 0 until n){
        sb.append(nums[i]).append("\n")
    }
    sb.deleteCharAt(sb.length-1)
    print(sb)
}