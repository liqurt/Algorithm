package baekjoon._18258

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val myQueue = ArrayList<Int>()
    var head = 0
    var tail = 0
    repeat(n){
        val command = StringTokenizer(br.readLine())
        when(command.nextToken()){
            "push" -> {
                val item = command.nextToken().toInt()
                myQueue.add(item)
                tail++
            }
            "pop" -> {
                var item = -1
                if(head != tail){
                    item = myQueue[head]
                    head++
                }
                sb.append(item).append("\n")
            }
            "size" -> {
                val size = tail - head
                sb.append(size).append("\n")
            }
            "empty" -> {
                val size = tail - head
                if(size == 0){
                    sb.append("1").append("\n")
                }else{
                    sb.append("0").append("\n")
                }
            }
            "front" -> {
                val size = tail - head
                if(size == 0){
                    sb.append(-1).append("\n")
                }else{
                    sb.append(myQueue[head]).append("\n")
                }
            }
            "back" -> {
                val size = tail - head
                if(size == 0){
                    sb.append(-1).append("\n")
                }else{
                    sb.append(myQueue[tail-1]).append("\n")
                }
            }
        }
    }
    print(sb)
}