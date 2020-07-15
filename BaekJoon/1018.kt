import java.lang.Integer.min

fun conservativeWay(board : Array<Array<String>>, clipSize : Int) : Int{
    var count = 0
    for(loop1 in 0 until clipSize){
        for(loop2 in 0 until clipSize){
            if(
                    ((loop1+loop2)%2 == 0)
                    and
                    (board[0][0] != board[loop1][loop2])
            ){
                count++
            }
            if(
                    ((loop1+loop2)%2 != 0)
                    and
                    (board[0][0] == board[loop1][loop2])
            ){
                count++
            }
        }
    }
    return count
}

fun progressiveWay(board : Array<Array<String>>, clipSize : Int) : Int{
    var count = 0
    for(loop1 in 0 until clipSize){
        for(loop2 in 0 until clipSize){
            if(
                    ((loop1+loop2)%2 == 0)
                    and
                    (board[0][0] == board[loop1][loop2])
            ){
                count++
            }
            if(
                    ((loop1+loop2)%2 != 0)
                    and
                    (board[0][0] != board[loop1][loop2])
            ){
                count++
            }
        }
    }
    return count
}

fun main(args: Array<String>) {
    val clipsize : Int = 8
    val (n, m) = readLine()!!.split(' ').map(String::toInt)
    val board : Array<Array<String>> = Array(n) {Array(m) {"X"}}
    for(loop in 0 until n){
        board[loop] = readLine()!!.toCharArray().map { it.toString() }.toTypedArray()
    }
    var minOfMin = 9999
    var nowMin : Int
    var clipBoard : Array<Array<String>> = Array(clipsize) {Array(clipsize) {"X"}}
    for(loop1 in 0 until n-clipsize+1){
        for(loop2 in 0 until m-clipsize+1){
            for(loop3 in 0 until clipsize){
                clipBoard[loop3] = board[loop1+loop3].copyOfRange(loop2,loop2+clipsize)
            }
            //min([0][0]의 색을 유지(보수), [0][0]의 색을 변경(진보))
            //println("col : $loop1 and row : $loop2")
            //println("Conservative : " + conservativeWay(clipBoard,clipsize))
            //println("Progressive : " + progressiveWay(clipBoard,clipsize))

            nowMin = min(conservativeWay(clipBoard,clipsize),progressiveWay(clipBoard,clipsize))
            if(nowMin < minOfMin){
                minOfMin = nowMin
            }
        }
    }
    print(minOfMin)
}