package baekjoon._1269

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val (aN, bN) = br.readLine().split(" ").map { it.toInt() }
    val ast = StringTokenizer(br.readLine()," ")
    val setA = mutableSetOf<Int>()
    while(ast.hasMoreTokens()){
        val item = ast.nextToken().toInt()
        setA.add(item)
    }
    val bst = StringTokenizer(br.readLine()," ")
    val setB = mutableSetOf<Int>()
    while(bst.hasMoreTokens()){
        val item = bst.nextToken().toInt()
        setB.add(item)
    }

    val setC = setA.minus(setB) + setB.minus(setA)
    sb.append(setC.size)
    print(sb)
}