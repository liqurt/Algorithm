package _1937;
//BOJ 1937, 욕심쟁이 판다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int n;
    static int[][] board;
    static int[][] maxStep;
    static int globalHigh = Integer.MIN_VALUE;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
//        입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        maxStep = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            while(st.hasMoreTokens()){
                board[i][n-st.countTokens()] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               int localHigh=  fill(i,j);
               if(globalHigh < localHigh){
                   globalHigh = localHigh;
               }
            }
        }

        System.out.println(globalHigh);
    }

    private static int fill(int i, int j) {
        if(maxStep[i][j] != 0){
            return maxStep[i][j];
        }
        else{
            maxStep[i][j] = 1;
            for (int direction = 0; direction < 4; direction++) {
                int newI = i + dy[direction];
                int newJ = j + dx[direction];
                if(newI<0 || n-1<newI || newJ<0 || n-1<newJ) { // 벽 체크
                    continue;
                }
                else{
                    if(board[i][j] < board[newI][newJ]){ // 탐색한 곳이 지금 대나무보다 양이 많으면
                        maxStep[i][j] = Math.max(maxStep[i][j], fill(newI,newJ) + 1); // 로컬 vs 후보군
                    }
                }
            }
        }

        return maxStep[i][j];
    }

}

// c1 : M = 1 -> 갈 곳이 없음
// c2 : M = max(사방탐색해서 가장 큰 놈) + 1