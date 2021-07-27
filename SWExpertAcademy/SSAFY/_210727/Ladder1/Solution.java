package _210727.dailyHW.Ladder1;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        final int T = 10;
        final int LADDER_ARRAY_SIZE = 100;
        final int DESTINATION = 2;

        System.setIn(new FileInputStream("./src/_210727/dailyHW/Ladder1/input.txt"));
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sc.nextInt(); // test_case, 큰 의미없음
            int[][] ladder = new int[LADDER_ARRAY_SIZE][LADDER_ARRAY_SIZE];
            for(int i=0 ; i<LADDER_ARRAY_SIZE ; i++){
                for(int j=0 ; j<LADDER_ARRAY_SIZE ; j++){
                    ladder[i][j] = sc.nextInt();
                }
            }

            int startPositionCol = -1;
            for(int i=0 ; i<LADDER_ARRAY_SIZE ; i++){
                if(ladder[LADDER_ARRAY_SIZE-1][i] == DESTINATION){
                    startPositionCol = i;
                }
            }

            int i = LADDER_ARRAY_SIZE-1;
            int j = startPositionCol;
            int left;
            int right;
            int up;

            while(true){
                if(j-1<0){
                    left = 0;
                }else{
                    left = ladder[i][j-1];
                }
                if(LADDER_ARRAY_SIZE<=j+1){
                    right = 0;
                }else{
                    right = ladder[i][j+1];
                }
                if(i-1 < 0){
                    up = 0;
                }else{
                    up = ladder[i-1][j];
                }

                if(left==0 && right==0 && up==0){
                    System.out.println("#"+test_case+" "+j);
                    break;
                }
                else if(left==0 && right==0){
                    ladder[i][j] = 0;
                    i--;
                }
                else if(left == 1){
                    ladder[i][j] = 0;
                    j--;
                }
                else if(right == 1){
                    ladder[i][j] = 0;
                    j++;
                }
            }
        }
    }
}