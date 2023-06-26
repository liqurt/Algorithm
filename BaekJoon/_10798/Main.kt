package baekjoon._10798

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val TIMES = 5

    // ver 1. 2차원 배열 안쓰기
    /*

        val words = Array<String>(TIMES) {""}
        var maxWordLength = -1
        repeat(TIMES){
            words[it] = br.readLine()
            if(maxWordLength < words[it].length){
                maxWordLength = words[it].length
            }
        }

        var i = 0
        var j = 0
        while(j<maxWordLength){
            i=0
            while(i<TIMES){
                if(j < words[i].length){
                    sb.append(words[i][j])
                }
                i++
            }
            j++
        }
        print(sb)

    */

    // ver 2. 2차원 배열 쓰기
    var maxWordLength = -1
    val words = Array(TIMES) { charArrayOf() }
    repeat(TIMES) {
        words[it] = br.readLine().toCharArray()
        if(maxWordLength < words[it].size){
            maxWordLength = words[it].size
        }
    }

    var i = 0
    var j = 0

    while (j < maxWordLength) {
        i=0
        while (i < TIMES) {
            if(j < words[i].size){
                sb.append(words[i][j])
            }
            i++
        }
        j++
    }

    print(sb)
}