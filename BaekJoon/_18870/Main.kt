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
    val st = StringTokenizer(br.readLine())
    val points = Array(n){0}
    while (st.hasMoreTokens()) {
        val i = n - st.countTokens()
        val v = st.nextToken().toInt()
        points[i] = v
    }
}

/*
* 2 4 -10 4 -9
* -10 -9 2 4 4
*
* map(v,i)
* -10 0
* -9 1
* 2 2
* 4 3
*
* 1. 입력 받을것 다 받고 그걸 원본 어레이에 저장
* 2. 원본 어레이 하나 복제함, 그걸 value기준 sort.
* 3. hashMap만듬
* 4. 정렬한 어레이로 해쉬맵을 제작, key = v, value = 최초로 나오는 index
* 5. 원본 어레이 0부터 끝까지 루프
* 6. 원본 어레이 값을 가져와 키로 삼음
* 7. 그 키로 해쉬맵 탐색
* */