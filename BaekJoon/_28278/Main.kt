package baekjoon._28278

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val myStack = mutableListOf<Int>()
    for (i in 1..n) {
        val command = br.readLine()
        when(command[0]){
            '1' -> {
                val pushCommand = command.split(" ").map { it.toInt() }
                val item : Int = pushCommand[1]
                myPush(item, myStack)
            }
            '2' -> {
                sb.append(myPop(myStack)).append("\n")
            }
            '3' -> {
                sb.append(mySize(myStack)).append("\n")
            }
            '4' -> {
                sb.append(myIsEmpty(myStack)).append("\n")
            }
            '5' -> {
                sb.append(myPeek(myStack)).append("\n")
            }
        }
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}

fun myPush(item : Int, myStack : MutableList<Int>){
    myStack.add(item)
}
fun myPop(myStack : MutableList<Int>) : Int{
    return if(myIsEmpty(myStack) == 1) -1
    else{
        val top = myStack.lastIndex
        val item = myStack[top]
        myStack.removeAt(top)
        item
    }
}
fun mySize(myStack : MutableList<Int>) : Int{
    return if(myIsEmpty(myStack) == 1) 0
    else{
        myStack.size
    }
}
fun myIsEmpty(myStack : MutableList<Int>) : Int{
    return if(myStack.isEmpty()) 1 else 0
}
fun myPeek(myStack : MutableList<Int>) : Int{
    return if(myIsEmpty(myStack) == 1) -1
    else {
        val top = myStack.lastIndex
        myStack[top]
    }
}