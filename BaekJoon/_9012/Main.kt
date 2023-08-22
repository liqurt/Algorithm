package baekjoon._9012

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val t = br.readLine().toInt()
    repeat(t){
        val parenthesisString = br.readLine().toCharArray()
        if(isThisVPSButGreedy(parenthesisString)){
            sb.append("YES").append("\n")
        } else{
            sb.append("NO").append("\n")
        }
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}

// 스택으로 풀기
fun isThisVPS(parenthesisString: CharArray): Boolean {
    val checkVPS = Stack<Char>()
    for(i in parenthesisString.indices){
        if(parenthesisString[i] == '('){
            checkVPS.push('(')
        }else{
            if(checkVPS.isEmpty()){
                return false
            }
            checkVPS.pop()
        }
    }
    return checkVPS.isEmpty()
}

// 그리디로 풀기?
fun isThisVPSButGreedy(parenthesisString: CharArray): Boolean{
    var top = -1
    for(i in parenthesisString.indices){
        if(parenthesisString[i] == '('){
            top++
        }else{
            if(top == -1){
                return false
            }
            top--
        }
    }
    return top == -1
}