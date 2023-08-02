package baekjoon._14425

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val hm = HashMap<String, Boolean>()
    var count = 0u // 그냥 한번 써보는 UnsignedInt
    // 입력
    val (n,m) = br.readLine().split(" ").map{it.toInt()}
    for(i in 0 until n){
        val str = br.readLine()
        hm[str] = true // hashmap에 찾을 값 넣기
    }
    for(i in 0 until m){
        val str = br.readLine()
        if(hm.containsKey(str)){ // 입력 받은게 hashMap에 있는가?
            count++
        }
    }

    sb.append(count)
    print(sb)
}