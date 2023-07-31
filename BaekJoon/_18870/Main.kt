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

    // 입력
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine(), " ")
    val originalPoints = Array(n) { 0 }
    var xi = 0
    while (st.hasMoreTokens()) {
        val xv = st.nextToken().toInt()
        originalPoints[xi] = xv
        xi++
    }

    // 정렬 + 해시맵에 저장
    /*
   index를 압축값으로 쓰면
   input이
   5
   5 4 3 2 2
   일때,

   output이
   4 3 2 0 0
   이 된다.
   */
    val sortedPoints = originalPoints.sortedArray()
    val hm = HashMap<Int, Int>(n)
    var compressedValue = 0
    for (i in sortedPoints.indices) {
        if (!hm.containsKey(sortedPoints[i])) {
            hm[sortedPoints[i]] = compressedValue
            compressedValue++
        }
    }

    //출력
    for (i in 0 until n) {
        sb.append(hm[originalPoints[i]]).append(" ")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}
/*
* 1. 입력
* 2. 정렬
* 3. 중복 제거
* 4. 인덱스가 곧 압축된 좌표가 된다...
* */

/*
input
20
1 -2 -6 -8 3 2 99 100 100000 -100000 100000 12 -13 85 99 1 -90 -80 -88 20
* */