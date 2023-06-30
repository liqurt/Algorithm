package baekjoon._1978

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val N = br.readLine().toInt()
    val numbers = br.readLine().split(' ').map { it.toInt() }
    var countPrimeNumber = 0

    repeat(N) {
        val num = numbers[it]
        if (num == 1) {
        } else {
            var isThisPrime = true
            var v = 2
            while (v < num) {
                if (num % v == 0) {
                    isThisPrime = false
                    break
                }
                v++
            }
            if (isThisPrime)
                countPrimeNumber++
        }
    }

    sb.append(countPrimeNumber)
    print(sb)
}
