package _210802.dailyHW.암호생성기;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
//1
//9550 9556 9550 9553 9558 9551 9551 9551
public class Solution {

    public static void main(String args[]) throws Exception{

        System.setIn(new FileInputStream("./src/_210802/dailyHW/암호생성기/input.txt"));
        Scanner sc = new Scanner(System.in);
        final int T = 10;
        final int N = 8;
        final int LOOP_CYCLE = 5;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sc.nextInt(); // test_case
            int[] queue = new int[N];
            for(int i =0 ; i<N ; i++){
                queue[i] = sc.nextInt();
            }

            //cycle
            boolean flag = false;
            while(true) {
                for (int i = 0; i < LOOP_CYCLE; i++) {
                    int temp = queue[0] - (i + 1);
                    if (temp < 0) temp = 0;
                    for (int j = 0; j < N - 1; j++) {
                        queue[j] = queue[j + 1];
                    }
                    queue[N - 1] = temp;
                    if(queue[N-1] == 0) flag=true;
                    if(flag) break;
                }
                if (flag) break;
            }

            String result="";
            for(int i=0 ; i<N ; i++){
                result += " "+queue[i];
            }
            System.out.println("#"+test_case+" "+result);
        }
    }
}