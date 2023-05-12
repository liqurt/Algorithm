package baekjoon._10810

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

class Main {
}

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    var tokenizer = StringTokenizer(br.readLine())
    val N = tokenizer.nextToken().toInt()
    val M = tokenizer.nextToken().toInt()
    val arr = IntArray(N)
    var loopIndex = 0

    repeat(M){
        tokenizer = StringTokenizer(br.readLine())
        val i = tokenizer.nextToken().toInt()
        val j = tokenizer.nextToken().toInt()
        val k = tokenizer.nextToken().toInt()
        loopIndex = i-1

        while(true){
            arr[loopIndex] = k
            loopIndex++
            if(j <= loopIndex){
                break
            }
        }
    }

    val stringBuilder = StringBuilder()
    loopIndex = 0
    repeat(N){
        stringBuilder.append(arr[loopIndex].toString())
        stringBuilder.append(" ")
        loopIndex++
    }
    bw.write(stringBuilder.toString().trim())
    bw.flush()
    bw.close()

}

/*
0 0 0 0 0 N5 M4
        I1 J2 K3

        3 3 000
        3 3 4 4 0
        1 1 1 1 0
        1 2 1 1 0
        */