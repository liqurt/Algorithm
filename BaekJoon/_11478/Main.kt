package baekjoon._11478

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
    // 참고자료
    // https://www.acmicpc.net/board/view/122894(왜 중간중간에 해쉬를 비우는게 시간절약이 되는지)
    // https://www.acmicpc.net/source/48313571(중간중간에 해쉬를 비워주는 케이스)

    // 왜 A가 B보다 시간과 메모리가 절약되는지... 당최 모르겠소...
    /*
     이유 > A는 하나의 해시셋에 죄다 때려박는다, 고로 해시 충돌이 일어날 확률이 큼, 해시 충돌 일어나면 선형으로 때려박음
     허나, B는 주기적으로 해시를 비워주기에 해시충돌이 일어날 건덕지가 줄어든다. 아.. 고마워라..
     */
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val s = br.readLine()
    val hashSet = HashSet<String>()
    var result = 0

    for(subStringSize in 1 .. s.length){
        for(L in 0 .. s.length-subStringSize){
            hashSet.add(s.substring(L,L+subStringSize))
        }
        // B. 중간 중간에 hashSet clear 하며 계산하기
        result += hashSet.size
        hashSet.clear()
    }
    // A. 다 돌고 계산하기
    /*
val result2 = hashSet.size
     */
    sb.append(result)
    print(sb)
}