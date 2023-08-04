package baekjoon._10816

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays
import java.util.StringTokenizer

class Main {
}

// lower_Bound, upper_bound 찾는 식으로 해보자

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val numArr = Array<Int>(n){0}
    val st = StringTokenizer(br.readLine()," ")
    repeat(n){
        numArr[it] = st.nextToken().toInt()
    }
    numArr.sort()
    val m = br.readLine().toInt()
    val st2 = StringTokenizer(br.readLine(), " ")
    repeat(m){
        val target = st2.nextToken().toInt()
        lower_bound(numArr, target)

    }
    println("")
}

// 정렬된 어레이를 받는다고 가정
fun lower_bound(arr : Array<Int>, target : Int) : Int{
    for(i in arr.indices){
        if(arr[i] == target){
            return i
        }
    }
    return arr.size
}

fun upper_bound(arr : Array<Int>, target : Int) : Int{
    for(i in arr.indices){
        if(target < arr[i]){
            return i
        }
    }
    return arr.size
}