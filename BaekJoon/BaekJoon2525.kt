import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

class BaekJoon2525 {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var tokenizer = StringTokenizer(br.readLine())
        val a = tokenizer.nextToken().toInt()
        val aToMinute = a*60
        val b = tokenizer.nextToken().toInt()

        tokenizer = StringTokenizer(br.readLine())
        val c = tokenizer.nextToken().toInt()

        var preResult = aToMinute+b+c
        val MIDNIGHT = 1440

        when{
            MIDNIGHT <= preResult -> {
                preResult -= MIDNIGHT
            }
        }

        val resultHour = preResult/60
        val resultMinute = preResult%60
        val result = "$resultHour $resultMinute"

        bw.write(result)
        bw.flush()
        bw.close()
    }
}