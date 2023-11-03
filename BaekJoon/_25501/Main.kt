package baekjoon._25501

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.properties.Delegates

class Main {
}

var recursionCount by Delegates.notNull<Int>()
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val t = br.readLine().toInt()
    repeat(t){
        recursionCount = 0
        val s = br.readLine()
        val result = isPalindrome(s)
        sb.append(result).append(" ").append(recursionCount).append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}

fun isPalindrome(str : String) : Int{
    return recursion(str, 0, str.length-1)
}

fun recursion(str : String, l : Int, r : Int) : Int{
    recursionCount++
    return if(l >= r)
        1
    else if(str[l] != str[r])
        0
    else
        recursion(str, l+1, r-1)
}