import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

class BaekJoon10807 {
    fun main(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val N = br.readLine().toInt()
        val tokenizer = StringTokenizer(br.readLine())
        val arr = IntArray(N)
        repeat(N){
            arr[it] = tokenizer.nextToken().toInt()
        }
        val v = br.readLine().toInt()

        val count = arr.count{
            it == v
        }
        bw.write(count.toString())
        bw.flush()
        bw.close()
    }
}