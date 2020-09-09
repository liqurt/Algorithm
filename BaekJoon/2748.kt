fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    var fibo = arrayOfNulls<Long>(91)
    fibo[0] = 0
    fibo[1] = 1

    if(N == 1){
        print(1)
    }
    else{
        for(loop in 2..90){
            fibo[loop] = fibo[loop-1]!! + fibo[loop-2]!!
            if(loop == N){
                print(fibo[loop])
            }
        }
    }
}
