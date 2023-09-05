package baekjoon._2164

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val q = LinkedList<Int>()
    repeat(n){
        q.add(it+1)
    }

    var putCardUnder = false
    while (1 < q.size){
        if(putCardUnder){
            q.add(q.pollFirst())
        }else{
            q.pollFirst()
        }
        putCardUnder = !putCardUnder
    }

    print(q.pollFirst())
}