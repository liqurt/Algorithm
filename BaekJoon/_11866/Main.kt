package baekjoon._11866

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val inputData = LinkedList<Int>()
    repeat(n) {
        inputData.add(it + 1)
    }
    sb.append('<').append(josephus(inputData, n, k)).deleteCharAt(1).deleteCharAt(sb.lastIndex).append('>')
    print(sb)
}

//    놀랍게도, 브루트포스말고 큐로도 해결볼수 있다.
//    1. 'k-1' 회 까지는 큐 앞에서 뽑아 뒤로 붙인다.
//    2. 'k' 회 차의 아이템은 요세푸스 순열에 놓는다.
//    근데, 브루트포스로 하는게 메모리를 덜 쓰네? 시간은 비슷함
fun josephus(q: LinkedList<Int>, n: Int, k: Int): ArrayList<Int> {
    val result = ArrayList<Int>()
    var step = 1
    while(result.size < n){
        if(step < k){
            q.addLast(q.pollFirst())
            step++
        }else{
            result.add(q.pollFirst())
            step = 1
        }
    }
    return result
}