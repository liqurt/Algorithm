package baekjoon._1620

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val hmNameToNumber = HashMap<String,Int>()
    val hmNumberToName = HashMap<Int,String>()
    for(pokemonNumber in 1 .. n){
        val pokemonName = br.readLine()
        hmNameToNumber[pokemonName] = pokemonNumber
        hmNumberToName[pokemonNumber] = pokemonName
    }

    for(i in 0 until m){
        val originalQuestion = br.readLine()
        val question = originalQuestion.toIntOrNull() // 숫자가 아니라면 null이 되겠지
        if(question == null){
            sb.append(hmNameToNumber[originalQuestion])
        }else{
            sb.append(hmNumberToName[question])
        }
        sb.append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}