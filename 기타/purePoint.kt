package com.ssafy.hwandroidui_gumi_06_yoonseungil

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    PurePoint().solve()
}

class PurePoint {
    fun solve(){

        val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
        val t = bufferedReader.readLine().toInt()
        for(tc in 1..t) {
            var pureOdd = 0
            var pureEven = 0
            val n = bufferedReader.readLine().toInt()
            val arr = Array(n) {
                Array(n) {
                    -1
                }
            }
            for(line in 0 until n){
                arr[line] = bufferedReader.readLine().split(" ").map{it.toInt()}.toTypedArray()
            }

            for(i in 1 until n-1){
                for(j in 1 until n-1){
                    if(checkPureOdd(arr,i,j)) pureOdd++
                    if(checkPureEven(arr,i,j)) pureEven++
                }
            }

            println("#$tc $pureEven $pureOdd")
        }
    }

    private fun checkPureEven(arr: Array<Array<Int>>, i: Int, j: Int) : Boolean {
        val dy = arrayOf(-1, 1, 0 ,0)
        val dx = arrayOf(0, 0, -1 ,1)

        for(a in 0..3){
            if(arr[i+dy[a]][j+dx[a]]%2 != 0){
                return false
            }
        }
        return true
    }

    private fun checkPureOdd(arr: Array<Array<Int>>, i: Int, j: Int) : Boolean {
        val dy = arrayOf(-1, 1, 0 ,0)
        val dx = arrayOf(0, 0, -1 ,1)

        for(a in 0..3){
            if(arr[i+dy[a]][j+dx[a]]%2 != 1){
                return false
            }
        }
        return true
    }

}