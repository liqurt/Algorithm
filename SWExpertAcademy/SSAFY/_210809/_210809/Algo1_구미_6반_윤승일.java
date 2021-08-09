package _210809.test;

import java.util.Scanner;
import java.io.FileInputStream;

class P1 {
    static int[][] sumBoard;
    static int sum=0;
    static int[][] board;

    static final int[] dy = {-1,-1,1,1};
    static final int[] dx = {-1,1,1,-1};

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        final int T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 입력
            final int N=sc.nextInt();
            board = new int[N][N];
            for(int i =0 ; i<N ; i++){
                for(int j =0 ; j<N ; j++){
                    board[i][j] = sc.nextInt();
                }
            }

            // sumBoard 제작
            sumBoard = new int[N][N];
            for(int i =0 ; i<N ; i++){
                for(int j =0 ; j<N ; j++){
                    if(board[i][j] == -1){
                        sumBoard[i][j] = -1; // 계산할 지점이 -1이면 그냥 넘어간다
                    }else{
                        sum = 0;
                        for(int k=0 ; k<4 ; k++){
                            look(i+dy[k],j+dx[k],N,k);
                        }
                        sumBoard[i][j] = sum+board[i][j];
                    }
                }
            }

            // 입력
            int max = Integer.MIN_VALUE;
            for(int i =0 ; i<N ; i++){
                for(int j =0 ; j<N ; j++){
                    if(max < sumBoard[i][j]){
                        max = sumBoard[i][j];
                    }
                }
            }
            System.out.println("#"+test_case+" "+max);
        }
    }

    private static void look(int iY, int iX, int N, int k) {
        if(!isWall(iY,iX,N)){ // 벽이 아니면
            if(board[iY][iX] != -1){ // 이동 지점이 -1이 아니면
                sum+= board[iY][iX]; // 더한다.
                look(iY+dy[k],iX+dx[k],N,k); // 그쪽 방향으로 더 탐색함.
            }
        }
    }

    private static boolean isWall(int y, int x, int N){
        return 0 > y || N <= y || 0 > x || N <= x; //벽에 걸리면 true, 아니면 false
    }

}