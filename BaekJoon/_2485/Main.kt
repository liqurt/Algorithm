package baekjoon._2485

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
    // -메모리를 오지게 먹는 방법-
    // 1. 주어진 가로수에서 최소 나무 거리(T)를 구한다.
    // 2. 1부터 최소나무거리(포함) 까지 나무를 심어본다.
    // 3. 나무를 심은 가로수의 간격이 일정한지 확인한다.
    // 4. 일정하다면, 그것을 위해 소비한 나무의 수를 센다.
    // 5. 일정하지 않다면, 무시한다.
    // 6. 소비한 나무의 수 중, 가장 적게 소비한 나무를 출력.

    // -메모리를 오지게 안 먹는 방법-
    // 1. 주어진 나무들 간의 간격을 구한다.
    // 2. 간격들의 최대공약수가 곧 최적의 간격이 된다.
    // 3. 심은 나무를 구한다.
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val street = mutableListOf<Int>()
    repeat(n){
        street.add(br.readLine().toInt())
    }

    val intervals = treeInterval(street)
    val oI = optimalInterval(intervals)
    val result = plantingTrees(street, oI, n)
    sb.append(result)
    print(result)
}

fun optimalInterval(intervals : List<Int>): Int {
    var interval = gcd(intervals[0],intervals[1])
    for(i in 2 .. intervals.lastIndex){
        interval = gcd(interval, intervals[i])
    }
    return interval
}

fun plantingTrees(street: List<Int>, optimalInterval: Int, givenTrees: Int): Int {
    var count = 0
    for (location in street[0]..street[street.lastIndex] step (optimalInterval)) {
        count++
    }
    return count - givenTrees
}

fun treeInterval(street : List<Int>) : List<Int>{
    val intervals = mutableListOf<Int>()
    repeat(street.size - 1){
        intervals.add(street[it+1] - street[it])
    }
    return intervals
}

fun gcd(a : Int, b : Int) : Int{
    return if(b == 0) {
        a
    }else{
        gcd(b, a%b)
    }
}