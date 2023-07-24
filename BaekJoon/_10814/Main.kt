package baekjoon._10814

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()

    val manArray = Array<Man>(n){Man(-1,"")}
    repeat(n){
        val man = br.readLine().split(" ")
        manArray[it] = Man(man[0].toInt(),man[1])
    }

    manArray.sortWith(compareBy<Man> { it.age })

    repeat(n){
        sb.append(manArray[it].age).append(" ").append(manArray[it].name).append("\n")
    }
    sb.deleteCharAt(sb.length-1)
    print(sb)
}

data class Man(
    val age : Int,
    val name : String
)