package SWEA._2001.파리퇴치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    // Scanner 대신 BufferedReader를 사용하는게 알고리즘에서 시간 절약의 70%를 차지한다!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine()); // valueOf 보다 parseInt가 더 절약이 된다!

        for (int testCase = 0; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " "); //delemeter를 입력해주면 조금 더 효율적임!
            int N = Integer.parseInt(st.nextToken()); // 배열크기 5~15
            int M = Integer.parseInt(st.nextToken()); // 파리채크기 2~N
            int[][] map = new int[N][N];
            for (int i = 0; i < map.length; i++) { // N == map.length
                String s = br.readLine();



                st = new StringTokenizer(s, " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i <= N - M; i++) { // i<=N-M 이 i<N-M+1 보다 좋은이유 : +1 이라는 연산을 loop숫자 만큼 줄일 수 있다!
                for (int j = 0; j <= N - M; j++) {

                    int sum = 0;
                    for (int k = 0; k < M; k++) {
                        for (int p = 0; p < M; p++) {
                            sum += map[i + k][j + p];
                        }
                    }
                    if (maxSum < sum) {
                        maxSum = sum;
                    }

                }
            }
            // str = "AA"+ "BB" 보다, sb.append("AA").append("BB")가 빠르다!
            sb.append("#").append(testCase).append(" ").append(maxSum);// println 은 너무나 오래 걸린다,
        }
        System.out.println(sb);
    }
    String s; // final char[] value; 수정불가! - 하지만 편의상 제공하긴 한다만 너무나 느리고 찌끼가 많이 남는다!
    StringBuilder sb1; // char[] value; 수정가능 - 예를 들어 3칸짜리 "abc" 를 만들면 16칸의 공간을 추가해서 19칸이 된다!(StringBuilder가 애초에 그렇게 디자인 되었음.)
    StringBuffer sb2;
}


// String s1 = new String("abcd");
// String s2 = "abcd"; // 권장되는 방법!(빠르다!, 메모리 절약!)

// s1 은 메모리의 heap에 생성된다!, s3의 값이 new String("abcd")여도
// 객체를 새로 생성하는 거기 때문에 자원을 더 많이 쓴다.

// s2 는 메모리의 classArea(상수 pool)에 생성된다.
// s3 의 값이 "abcd" 면, s2의 값을 재활용 할수있다. 객체를 만드는 시간을 절약할수 있다.

// String은 근본적으로 final char[] value라서 값을 바꿀수 없다. 그러나, s2는 값을 "wxyz"로 바꿀수 있다.
// 그 이유는, ConstantsPool 에 "wxyz" 를 생성하고 그걸 referencing 하는 것.
// 그렇기 때문에 "A"+"B"+"C"를 하면 상수풀에 3번 뭔가를 생성하기 때문에 느리고 찌꺼기가 많이 남는다!