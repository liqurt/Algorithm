package baekjoon._7785

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val enterMessage = "enter"
    val leaveMessage = "leave"

    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val hm = HashMap<String, Boolean>()
    val n = br.readLine().toInt()
    for(i in 0 until n){
        val (name, state) = br.readLine().split(" ")
        if(state == enterMessage){
            hm[name] = true
        }else if (state == leaveMessage){
            if(hm.containsKey(name)){
                hm.remove(name)
            }
        }
    }

    val nowWorking = hm.keys.toList().sortedDescending()
    for(worker in nowWorking){
        sb.append(worker).append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}