package _210727.dailyHW.Magnetic;

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        final int TABLE_SIZE = 100;
        final int T = 10;
        int[][] table = new int [TABLE_SIZE][TABLE_SIZE];

        //System.setIn(new FileInputStream("./src/_210727/dailyHW/Magnetic/input.txt"));
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sc.nextInt(); // 무조건 100, 별 의미 없음
            for(int i=0 ; i<TABLE_SIZE ; i++){
                for(int j=0 ; j<TABLE_SIZE ; j++){
                    table[i][j] = sc.nextInt();
                    //0 - 없음
                    //1 - N
                    //2 - S
                }
            }

            //전치 (좌측이 N, 우측이 S)
            for(int i=0 ; i<TABLE_SIZE ; i++){
                for(int j=0 ; j<TABLE_SIZE ; j++){
                    if(i<j){
                        int temp;
                        temp = table[i][j];
                        table[i][j] = table[j][i];
                        table[j][i] = temp;
                    }
                }
            }

            int deadlock=0;
            for(int i=0 ; i<TABLE_SIZE ; i++){
                int target = -1;
                for(int j=0 ; j<TABLE_SIZE ; j++){
                    if(table[i][j] == 1){
                        target = table[i][j];
                    }
                    if(target == 1 && table[i][j] == 2){
                        deadlock++;
                        target = -1;
                    }
                }
            }
            System.out.println("#"+test_case+" "+deadlock);
        }
    }
}