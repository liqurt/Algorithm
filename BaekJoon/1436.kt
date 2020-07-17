
fun main(args: Array<String>) {
    val n : Int = readLine()!!.toInt()
    var num : Int  = 0
    var serialNum = 0
    val title : String = "666"

    while(true){
        if(num.toString().contains(title)){
            serialNum++
        }
        if(serialNum == n){
            println(num)
            break
        }
        num++
    }
}