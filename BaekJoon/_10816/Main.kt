package baekjoon._10816

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Main {
    // 참고한 곳 : (https://wtg-study.tistory.com/29)
}


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
        sb.append(upperBound(numArr, target) - lowerBound(numArr, target)).append(" ")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}

fun lowerBound (arr : Array<Int>, k : Int) : Int{
    var L = 0
    var R = arr.size - 1
    while(L<R){
        val M = (L+R) / 2
        if(k <= arr[M]){
            R = M
        }else{
            L = M+1
        }
    }
    return R
}

fun upperBound (arr : Array<Int>, k : Int) : Int{
    if(k == arr[arr.lastIndex])
        return arr.size
    var L = 0
    var R = arr.size - 1
    while(L<R){
        val M = (L+R) / 2
        if(k < arr[M]){
            R = M
        }else{
            L = M+1
        }
    }
    return R
}