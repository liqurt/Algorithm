var c:Array<Boolean> = Array(10) {false}
var a:Array<Int> = Array(10) {0}

fun func(index:Int, n:Int, m:Int){
    if(index == m){
        for(i in 0 until m){
            print(a[i])
            if(i != m-1){
                print(' ')
            }
        }
        println()
        return
    }
    for(i in 1..n){
        if(c[i]){
            continue
        }
        c[i] = true
        a[index] = i
        func(index+1,n,m)
        c[i] = false
    }
}

fun main(args: Array<String>) {
    val (N, M) = readLine()!!.split(' ').map(String::toInt)
    func(0,N,M)
}