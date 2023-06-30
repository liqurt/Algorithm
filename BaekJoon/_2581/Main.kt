package baekjoon._2581

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.sqrt

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val M = br.readLine().toInt()
    val N = br.readLine().toInt()

    var i = M
    var sumOfPrime = 0
    var minPrime = -1
    while (i <= N) {
        if (isThisPrime(i)) {
            sumOfPrime += i
            if (minPrime == -1) {
                minPrime = i
            }
        }
        i++
    }

    if(minPrime == -1){
        sb.append(minPrime)
    }else{
        sb.append(sumOfPrime).append("\n").append(minPrime)
    }
    print(sb)
}

fun isThisPrime(n: Int): Boolean {
    if (n == 1) {
        return false
    }

    var i = 2
    val rootOfN = sqrt(n.toDouble()).toInt()
    while(i<=rootOfN){
        if(n % i == 0){
            return false
        }
        i++
    }

    return true
}