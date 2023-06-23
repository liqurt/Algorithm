package baekjoon._5086

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    while(true){
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        if((a == 0) && (b == 0)){
            break
        }else{
            if(b % a == 0){
                sb.append("factor").append("\n")
            }else if(a % b ==0){
                sb.append("multiple").append("\n")
            }else{
                sb.append("neither").append("\n")
            }
        }
    }
    sb.deleteCharAt(sb.length-1)
    print(sb)
}