package baekjoon._28279

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.LinkedList

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val arr = LinkedList<Int>()
    repeat(n){
        val command = br.readLine().split(" ").map { it.toInt() }
        when(command[0]){
            1 -> {
                val item = command[1]
                arr.addFirst(item)
            }
            2 -> {
                val item = command[1]
                arr.addLast(item)
            }
            3 -> {
                var item = -1
                if(arr.isNotEmpty()){
                    item = arr.pollFirst()
                }
                sb.append(item).append("\n")
            }
            4 -> {
                var item = -1
                if(arr.isNotEmpty()){
                    item = arr.pollLast()
                }
                sb.append(item).append("\n")
            }
            5 -> {
                sb.append(arr.size).append("\n")
            }
            6 -> {
                if(arr.isEmpty()){
                    sb.append(1)
                }else{
                    sb.append(0)
                }
                sb.append("\n")
            }
            7 -> {
                var item = -1
                if(arr.isNotEmpty()){
                    item = arr.peekFirst()
                }
                sb.append(item).append("\n")
            }
            8 -> {
                var item = -1
                if(arr.isNotEmpty()){
                    item = arr.peekLast()
                }
                sb.append(item).append("\n")
            }
        }
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}