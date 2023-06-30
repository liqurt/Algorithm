package baekjoon._25206

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val numberOfCourse = 20
    var totalCredit = 0.0
    var totalScore = 0.0
    repeat(numberOfCourse) {
        val st = StringTokenizer(br.readLine())
        val courseName = st.nextToken()
        val credit = st.nextToken().toDouble()
        val grade = st.nextToken()
        if(!grade.equals("P")){
            var gradeToScore : Double = -99999.0
            when(grade){
                "A+" -> gradeToScore= 4.5
                "A0" -> gradeToScore= 4.0
                "B+" -> gradeToScore= 3.5
                "B0" -> gradeToScore= 3.0
                "C+" -> gradeToScore= 2.5
                "C0" -> gradeToScore= 2.0
                "D+" -> gradeToScore= 1.5
                "D0" -> gradeToScore= 1.0
                "F" -> gradeToScore= 0.0
            }
            totalScore += credit*gradeToScore
            totalCredit += credit
        }
    }
    val GPA = totalScore/totalCredit
    sb.append(GPA)
    print(sb)
}