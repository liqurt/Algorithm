package baekjoon._2485

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.properties.Delegates

class Main {
}

const val MAX_NUM = 1000000000
var n by Delegates.notNull<Int>()
lateinit var trees: Array<Int>
var minTree = MAX_NUM
var maxTree = -1
fun main() {

    var minConsumedSapling = MAX_NUM
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    n = br.readLine().toInt()
    trees = Array<Int>(n){0}
    repeat(n) {
        val tree = br.readLine().toInt()
        trees[it] = tree
        if (tree < minTree) {
            minTree = tree
        }
        if (maxTree < tree) {
            maxTree = tree
        }
    }

    val maxDistance = getMinTreeDistance()
    for(interval in 1.. maxDistance){
        val exampleStreet = plantTree(interval)
        val consumedSapling = checkGoodInterval(exampleStreet)
        if(0 < consumedSapling){
            if(consumedSapling < minConsumedSapling){
                minConsumedSapling = consumedSapling
            }
        }
    }

    sb.append(minConsumedSapling)
    print(sb)
    // 1. 주어진 가로수에서 최소 나무 거리(T)를 구한다.
    // 2. 1부터 최소나무거리(포함) 까지 나무를 심어본다.
    // 3. 나무를 심은 가로수의 간격이 일정한지 확인한다.
    // 4. 일정하다면, 그것을 위해 소비한 나무의 수를 센다.
    // 5. 일정하지 않다면, 무시한다.
    // 6. 소비한 나무의 수 중, 가장 적게 소비한 나무를 출력.
}

fun checkGoodInterval(exampleStreet: List<Int>): Int {
    val firstInterval = exampleStreet[1] - exampleStreet[0]
    for (location in 1 until exampleStreet.size - 1) {
        val interval = exampleStreet[location + 1] - exampleStreet[location]
        if (interval != firstInterval) {
            return -1
        }
    }
    return exampleStreet.size - n
}

fun plantTree(interval: Int): List<Int> {
    var plantedStreet = ArrayList<Int>()
    plantedStreet.addAll(trees)
    for(location in minTree .. maxTree step(interval)){
        plantedStreet.add(location)
    }
    val a = plantedStreet.distinct().sorted()
    return a
}

fun getMinTreeDistance(): Int{
    var minDistance = MAX_NUM
    for(i in 0 until trees.size-1){
        val distance = trees[i+1] - trees[i]
        if(distance < minDistance){
            minDistance = distance
        }
    }
    return minDistance
}