import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

class BaekJoon11382 {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val tokenizer = StringTokenizer(br.readLine())
        var sum : Long = 0
        repeat(3){
            sum += tokenizer.nextToken().toLong()
        }
        bw.write(sum.toString())

        bw.flush()
        bw.close()
    }
}

// MEMO
// 수가 최대 10^12다.
// 이 수를 Int로 받을수는 없기에 Long으로 받아야만 NumberFormatException 을 회피 할 수 있음.