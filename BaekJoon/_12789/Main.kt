package baekjoon._12789

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val people = br.readLine().split(" ").map { it.toInt() }
    val eastLine = Stack<Int>()
    val southLine = Stack<Int>()
    val westLine = Stack<Int>()
    for (i in people.size - 1 downTo (0)) {
        eastLine.push(people[i])
    }

    val goodResult = "Nice"
    val badResult = "Sad"
    var result = goodResult
    var snackNumber = 1

    while (snackNumber <= n) {
        if(eastLine.isNotEmpty() && eastLine.peek() == snackNumber){
            westLine.push(eastLine.pop())
            snackNumber++
        }
        else if(southLine.isNotEmpty() && southLine.peek() == snackNumber){
            westLine.push(southLine.pop())
            snackNumber++
        }else{
            if(southLine.isNotEmpty() && southLine.peek() < eastLine.peek()){
                result = badResult
                break
            }else{
                southLine.push(eastLine.pop())
            }
        }
    }

    sb.append(result)
    print(result)
}

/*
정의
기존줄 = A, 한명씩만 설수 있는 공간 = B, 간식 받는 곳 = C
이동 가능 : A->B,C / B->C

새로 발견한 점.
B.top의 숫자를 BT라고 가정한다. B에 들어갈 숫자가 BT보다 크다면 실패한다.

1. A,B의 이동 가능한 학생들을 뽑는다. (1명 또는 2명)
2. C로 가기 적합한지 확인한다.
3. 적합하다! -> 해당 학생 C로 이동.
4. 부적합하다! -> A의 이동가능한 학생을 B로 이동.
5. 부적합하다! -> B로 방금 이동한 학생의 숫자가 기존 B의 맨 앞의 숫자보다 크다면 false
6. 별탈 없으면 true?
* */

// 안되는 경우
// (1) 2,3,1
// (2) 1,3,4,2
// (1) 2,3,1,4
// (1) 2,3,4,1
// (2) 2,4,1,3
