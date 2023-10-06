package baekjoon._2108

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val nums = mutableListOf<Int>()
    val bindo = IntArray(size = 8001)
    repeat(n){
        val item = br.readLine().toInt()
        nums.add(item)
        bindo[item+4000]++
    }
    nums.sort()
    println(nums.average().roundToInt()) // q1
    println(nums[n/2]) // q2

    val theNumberOfMaxBindo = bindo.max()
    var count = 1
    var result3 = -1
    for(i in bindo.indices){
        if(bindo[i] == theNumberOfMaxBindo){
            if(count == 2){
                result3 = i - 4000
                break
            }else{
                result3 = i - 4000
                count++
            }
        }
    }
    println(result3) // q3

    print(nums.max() - nums.min()) // q4
}