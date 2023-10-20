package baekjoon._20920

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

class Main {
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val arr = ArrayList<Pair<String, Int>>()
    val note = HashMap<String, Int>()

    repeat(n) {
        val word = br.readLine()
        if (m <= word.length) { // M 보다 짧은 길이의 단어의 경우 읽는 것만으로도 외울 수 있기 때문에 길이가 M 이상인 단어들만 외운다고 한다.
            if (!note.containsKey(word)) {
                note[word] = 1
            } else {
                note[word] = note[word]!! + 1
            }
        }
    }

    val noteIter = note.iterator()
    while (noteIter.hasNext()) {
        val item = noteIter.next()
        arr.add(Pair(item.key, item.value))
    }

    val wordNoteComparator = compareByDescending<Pair<String, Int>> { it.second }
        .then(compareByDescending { it.first.length })
        .then(compareBy { it.first })

    val newNewNote = arr.sortedWith(wordNoteComparator)
    val nnnIter = newNewNote.iterator()
    while(nnnIter.hasNext()){
        val item = nnnIter.next()
        sb.append(item.first).append("\n")
    }
    sb.deleteCharAt(sb.lastIndex)
    print(sb)
}