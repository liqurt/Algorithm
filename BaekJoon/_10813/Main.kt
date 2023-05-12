package baekjoon._10813

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var tokenizer = StringTokenizer(br.readLine())
    val N = tokenizer.nextToken().toInt()
    val M = tokenizer.nextToken().toInt()

    val arr = IntArray(N){i -> i+1}
    var i: Int
    var j: Int
    var temp : Int
    repeat(M){
        tokenizer = StringTokenizer(br.readLine())
        i = tokenizer.nextToken().toInt()
        j = tokenizer.nextToken().toInt()

        temp = arr[i-1]
        arr[i-1] = arr[j-1]
        arr[j-1] = temp
    }

    val sb = StringBuilder()
    var loopIndex = 0
    repeat(N){
        sb.append(arr[loopIndex].toString()).append(" ")
        loopIndex++
    }

    bw.write(sb.toString().trim())
    bw.flush()
    bw.close()
}