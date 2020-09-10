private val t = readLine()!!.toInt()
private val limitN = 100
private val triangleArray = arrayOfNulls<Long>(limitN+1)
private var n : Int = -1

fun main(args: Array<String>) {
    triangleArray[1] = 1
    triangleArray[2] = 1
    triangleArray[3] = 1
    triangleArray[4] = 2
    triangleArray[5] = 2
    for(index in 6..limitN){
        triangleArray[index] = triangleArray[index-1]!! + triangleArray[index-5]!!
    }
    for(testCase in 1..t){
        n = readLine()!!.toInt()
        println(triangleArray[n])
    }
}
