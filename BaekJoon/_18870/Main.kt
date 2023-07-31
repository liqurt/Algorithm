package baekjoon._18870

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap

class Main {
    /*
    순수하게 내 머리로 풀지 않았음, 남의 자료 참고함
    출처 : https://girawhale.tistory.com/38
    * */
}

fun main() { //아직도 시간초과... O(n) 보다 작은 걸 써야한다...
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine()) // O(n) = n
    val points = Array(n){0}
    while (st.hasMoreTokens()) {
        val i = n - st.countTokens()
        val v = st.nextToken().toInt()
        points[i] = v
    }

    val points2 = points.sortedArray().distinct()
    val hm = HashMap<Int,Int>(points2.size)
    for(i in 0 until points2.size){
        hm.put(points2[i], i)
    }

    for(i in 0 until n){
        print("${hm[i]} ")
    }
}
/*
* 1. 입력
* 2. 정렬
* 3. 중복 제거
* 4. 인덱스가 곧 압축된 좌표가 된다...
* */