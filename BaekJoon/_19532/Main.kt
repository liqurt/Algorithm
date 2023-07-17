package baekjoon._19532

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val st = StringTokenizer(br.readLine())
    val variables = MutableList<Int>(6){i -> -1}

    for(i in 0..5){
        variables[i] = st.nextToken().toInt()
    }

    var flag = 0
    for(x in -999..999){
        for(y in -999 .. 999){
            if((variables[0]*x + variables[1]*y == variables[2]) && (variables[3]*x + variables[4]*y == variables[5])){
                sb.append(x).append(" ").append(y)
                flag = 1
                break
            }
        }
        if(flag == 1){
            break
        }
    }

    print(sb)
}
