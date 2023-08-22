package baekjoon._13909

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

class Main {
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()

    sb.append(countOpenedWindowsBySquareNumber(n))
    print(sb)
}

// n 이하의 제곱수의 숫자를 찾자
// 오직 제곱수만이 약수의 갯수가 홀수임
fun countOpenedWindowsBySquareNumber(n: Int): Int {
    var m = 1
    var count = 0
    while(m*m <= n){
        m++
        count++
    }
    return count
}


fun countOpenedWindows(n : Int) : Int{
    if(n == 1)
        return 1
    else{
        return (countOpenedWindows(n-1) + (countDivisor(n) % 2))
    }
}

// 약수의 갯수가 홀수면 열리고 짝수면 닫힘
fun countDivisor(n: Int): Int {
    var count = 0
    val sqrtN = sqrt(n.toDouble()).toInt()
    for(i in 1..sqrtN){
        if(n % i == 0){
            count += 2
        }
    }
    if(sqrtN * sqrtN == n){
        count--
    }
    return count
}

/*
C C C C C C C C

1 1 1 1 1 1 1 1 1
1 2 1 2 1 2 1 2 1
1 2 3 2 1 3 1 2 3
1 2 3 4 1 3 1 4 3
1 2 3 4 5 3 1 4 3
1 2 3 4 5 6 1 4 3
1 2 3 4 5 6 7 4 3
1 2 3 4 5 6 7 8 3
1 2 3 4 5 6 7 8 9

1 2 2 3 2 4 2 4 3
1 0 0 1 0 0 0 0 1
약수의 숫자만큼 창문의 상태가 바뀜.
즉, 제곱수만 약수의 갯수가 홀수임.
n이하의 모든 제곱수의 갯수를 찾으면 되겠구나..

openedWindows(1) = 1
openedWindows(2) = openedWindows(1) + (2의 약수의 갯수 % 2)
oW(3) = oW(2) + (3의 약수의 갯수 % 2)

oW(n) = oW(n-1) + (n의 약수의 갯수 % 2)
*/
