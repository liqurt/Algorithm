package _210729.dailyHW.길찾기;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static final int T = 10;
    static final int SIZE = 100;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("./src/_210729/dailyHW/길찾기/input.txt"));
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int tc = sc.nextInt(); //test_case
            int numberOfRoad = sc.nextInt(); //길의 수

            // 각종 잡다구리 초기화
            boolean[] visited = new boolean[SIZE];
            int[] stack = new int[SIZE];
            int top = -1;
            int[][] board = new int [SIZE][SIZE];

            // 양방향 화살표가 아니니까 board[end][start]까지 1을 넣진 않겠다.
            for(int i=0,start,end ; i<numberOfRoad*2 ; i+=2){
                start = sc.nextInt();
                end = sc.nextInt();
                board[start][end] = 1;
            }

            // 출력 관련
            System.out.println("#"+test_case+" "+DFS(stack,top,visited,board,0));
        }

    }

    private static int DFS(int[] stack, int top, boolean[] visited, int[][] board, int v) {
        //푸시
        stack[++top] = v;
        while(top != -1){ // 비었냐?
            if(v == 99){ // 99까지 갔냐?
                return 1;
            }else{
                v = stack[top--]; // 팝
                if(!visited[v]){ // 안 들렸다면
                    visited[v] = true; // 들리겠다!
                    // comment - 이웃 찾는게 너무 미련함.. 이렇게 안하는 다른 방법이 분명 있을텐데
                    int[] wList = neighbor(board, v);
                    for (int i : wList) {
                        if (!visited[i]) {
                            stack[++top] = i;
                        }
                    }
                }
            }
        }
        return 0; // 99까지 가는길을 탐색하는 동안 결국 99까지 가지 못 했으며, 결국 스택이 동나버림
    }

    // comment - 이웃 찾기 : board에서 v를 기준으로 한 쪽 라인을 쭉 보고 값이 1이면 이웃이라고 판정
    private static int[] neighbor(int[][] board, int v){
        int neighborArrIndex = 0;
        // 이웃의 갯수 만큼 할당해주고 싶지만, 근본들만 쓰면서 그렇게 할수가 있는건가? 문제는 일단 가지치기가 2로 고정이라 나도 2를 씀
        int[] neighborArr = new int[2];
        for(int i = 0 ; i<SIZE ; i++){
            if(board[v][i] == 1){
                neighborArr[neighborArrIndex] = i;
                neighborArrIndex++;
            }
        }
        return neighborArr;
    }
}