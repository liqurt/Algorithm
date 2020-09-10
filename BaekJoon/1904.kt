val n = readLine()!!.toInt()
const val key = 15746
const val arrayLimit = 1000000

fun main(args: Array<String>) {
    val fibo = arrayOfNulls<Int>(4)
    // 처음엔 n만큼 어레이를 늘렸다. 이는 백준에서 런타임에러를 일으켰는데 아마 메모리 과다점유 아닐까 생각함.
    // fibo 내의 값은 계속 바뀌는데 val을 써도 문제가 없다..?!
    fibo[1] = 1
    fibo[2] = 2

    when(n){
        1 -> print(1)
        2 -> print(2)
        else ->{
            for(loop in 3..n){
                when(loop%3){
                    0 -> fibo[3] = (fibo[1]!!%key + fibo[2]!!%key) % key
                    1 -> fibo[1] = (fibo[2]!!%key + fibo[3]!!%key) % key
                    2 -> fibo[2] = (fibo[1]!!%key + fibo[3]!!%key) % key
                    //(a+b)%M = ((a%M) + (b%M))%M
                    //https://torbjorn.tistory.com/228(큰 수의 모듈러 연산)
                }
                if(loop == n){
                    when(loop%3){
                        0 -> print(fibo[3])
                        1 -> print(fibo[1])
                        2 -> print(fibo[2])
                    }
                }
            }
        }
    }
}
