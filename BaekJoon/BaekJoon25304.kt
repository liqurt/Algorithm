import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

class BaekJoon25304 {
    fun main(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val X = br.readLine().toInt()
        val N = br.readLine().toInt()

        var sum = 0
        repeat(N){
            val tokenizer = StringTokenizer(br.readLine())
            val a = tokenizer.nextToken().toInt()
            val b = tokenizer.nextToken().toInt()
            sum += a*b
        }

        if(sum == X){
            bw.write("Yes")
        }else{
            bw.write("No")
        }

        bw.flush()
        bw.close()
    }
}