package baekjoon._2501

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val (N, K) = br.readLine().split(' ').map{it.toInt()}

    var nowNumber = 0
    var yaksuOrder = 0
    while(true){
        nowNumber++
        if(N%nowNumber == 0){
            // 약수임
            yaksuOrder++
            if(yaksuOrder == K){
                sb.append(nowNumber)
                break
            }
        }
        if(N<nowNumber){
            // 무한루프방지
            sb.append(0)
            break
        }
    }
    print(sb)
}