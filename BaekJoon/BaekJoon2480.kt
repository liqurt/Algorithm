import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

class BaekJoon2480 {
    fun main(){
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val tokenizer = StringTokenizer(br.readLine())
        val dice = IntArray(3)
        repeat(3){
            dice[it] = tokenizer.nextToken().toInt()
        }

        var sameValueCount = 0
        var sameValue = 0
        if(dice[0] == dice[1]){
            sameValueCount++
            sameValue = dice[0]
        }
        if(dice[1] == dice[2]){
            sameValueCount++
            sameValue = dice[1]
        }
        if(dice[0] == dice[2]){
            sameValueCount++
            sameValue = dice[2]
        }
        val score : Int = when(sameValueCount){
            in 2..3 -> 10000 + dice[0] * 1000
            1 -> 1000 + sameValue * 100
            else -> dice.max() * 100
        }

        bw.write(score.toString())
        bw.flush()
        bw.close()

    }
}