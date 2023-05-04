import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class BaekJoon25314 {
    fun main(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val N = br.readLine().toInt()

        val sb = StringBuilder()
        repeat(N/4){
            sb.append("long ")
        }
        sb.append("int")
        bw.write(sb.toString())
        bw.flush()
        bw.close()
    }
}