package _210806.dailyHW.정사각형_방;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int N;
    static int[][] rooms;
    static int[][] memo;
    static int move;
    final static int[] dy = {-1,1,0,0};
    final static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        final String filePath = "./src/_210806/dailyHW/정사각형_방/input.txt";
        System.setIn(new FileInputStream(filePath));
        Scanner sc = new Scanner(System.in);
        final int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            //입력 관련 잡다구리
            N = sc.nextInt();
            rooms = new int[N][N];
            memo = new int[N][N];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ;j++){
                    rooms[i][j] = sc.nextInt();
                }
            }

            // 각 방마다 최대 이동 가능 횟수 계산
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ;j++){
                    move=1;
                    test(i,j);
                    memo[i][j] = move;
                }
            }

            // 최대 이동 가능 횟수인 방 중, 최소 방 번호 탐색
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ;j++){
                    if(max<memo[i][j]){
                        max = memo[i][j];
                        min = rooms[i][j];
                    }else if(max == memo[i][j]){
                        if(rooms[i][j]<min){
                            min = rooms[i][j];
                        }
                    }
                }
            }

            //출력 관련 잡다구리
            System.out.printf("#%d %d %d\n",test_case,min,max);
        }
    }

    // 벽 체크
    private static boolean isWall(int y, int x){
        return y < 0 || x < 0 || N <= y || N <= x;
    }

    private static void test(int i, int j) {
        for(int a=0 ; a<4 ; a++){
            if(!isWall(i+dy[a], j+dx[a])){
                if(rooms[i][j] + 1 == rooms[i+dy[a]][j+dx[a]]){
                    if(memo[i+dy[a]][j+dx[a]] == 0){
                        // 가고자 하는 방에 최대 이동 횟수가 없다면, 재귀를 통해 직접 알아냄.
                        move++;
                        test(i+dy[a],j+dx[a]);
                    }else{
                        // 가고자 하는 방에 이미 최대 이동 횟수가 있다면 굳이 재귀할 필요 없음.
                        move+=memo[i+dy[a]][j+dx[a]];
                    }
                }
            }
        }
    }
}