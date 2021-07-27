package _210727.dailyHW.Sum;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution
{
    public static void main(String[] args) throws Exception
    {
        final int BOARDSIZE = 100;
        final int T = 10;
        int[][] board = new int [BOARDSIZE][BOARDSIZE];
        int sum = 0;


        System.setIn(new FileInputStream("./src/_210727/dailyHW/Sum/input.txt"));
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= T; test_case++) {
            // 입력
            int max = Integer.MIN_VALUE;
            sc.nextInt(); // test_case, 별 의미 없음
            for(int i=0 ; i<BOARDSIZE ; i++){
                for(int j=0 ; j<BOARDSIZE ; j++){
                    board[i][j] = sc.nextInt();
                }
            }

            // 행,열,대각 합 구하기

            // 행
            for(int i=0 ; i<BOARDSIZE ; i++){
                sum = 0;
                for(int j=0 ; j<BOARDSIZE ; j++){
                    sum+=board[i][j];
                }
                if(max<sum){
                    max = sum;
                }
            }

            // 열
            for(int j=0 ; j<BOARDSIZE ; j++){
                sum = 0;
                for(int i=0 ; i<BOARDSIZE ; i++){
                    sum+=board[i][j];
                }
                if(max<sum){
                    max = sum;
                }
            }

            //대각(\)
            sum = 0;
            for(int i=0 ; i<BOARDSIZE ; i++){
                sum+=board[i][i];
            }
            if(max<sum){
                max = sum;
            }

            //대각(/)
            sum = 0;
            for(int i=0 ; i<BOARDSIZE ; i++){
                sum+=board[BOARDSIZE-1-i][i];
            }
            if(max<sum){
                max = sum;
            }

            //최대값
            System.out.println("#"+test_case+" "+max);
        }
        }
    }

