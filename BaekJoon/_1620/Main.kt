package baekjoon._1620

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
//    남의 뇌를 참고함
//    https://youjourney.github.io/archivers/BOJ1620
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val pokemonHashMap = HashMap<String,String>()
    for(pokemonNumber in 1 .. n){
        val pokemonName = br.readLine()
        pokemonHashMap[pokemonNumber.toString()] = pokemonName
        pokemonHashMap[pokemonName] = pokemonNumber.toString()
    }

    for(i in 0 until m){
        sb.append(pokemonHashMap[br.readLine()]).append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}