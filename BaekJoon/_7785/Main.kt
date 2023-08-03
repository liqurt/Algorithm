package baekjoon._7785

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.TreeMap

class Main {
}

fun main(){
    val enterMessage = "enter"
    val leaveMessage = "leave"

    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val tm = TreeMap<String, Boolean>(reverseOrder())
    val n = br.readLine().toInt()
    for(i in 0 until n){
        val (name, state) = br.readLine().split(" ")
        if(state == enterMessage){
            tm[name] = true
        }else if (state == leaveMessage){
            if(tm.containsKey(name)){
                tm.remove(name)
            }
        }
    }

    val tmIter = tm.iterator()
    tmIter.forEach {
        sb.append(it.key).append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}