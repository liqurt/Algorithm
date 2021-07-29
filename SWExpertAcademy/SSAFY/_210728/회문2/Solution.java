package _210728.dailyHW.회문2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws Exception
    {
        final int T = 10;
        final int BOARDSIZE = 100;

        System.setIn(new FileInputStream("./src/_210728/dailyHW/회문2/input.txt"));
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sc.nextInt(); // test_case, 큰 의미없음
            char[][] board = new char[BOARDSIZE][BOARDSIZE];
            for(int i = 0; i<BOARDSIZE ; i++){
                    String temp = sc.next();
                    String temp2[] = temp.split("");
                    for(int j=0 ;j<BOARDSIZE;j++){
                        board[i][j] = temp2[j].charAt(0);
                    }
            }
            int max=-1;

            char[] ca;
            // 가로
            for(int i=0 ; i<BOARDSIZE ; i++){
                for(int start = 0; start<BOARDSIZE ; start++){
                    for(int end = start ; end<BOARDSIZE ; end++){
                        ca = new char[end-start+1];
                        for(int k=0, S=start; k<ca.length ; k++){
                            if(end<S){
                                break;
                            }
                            ca[k] = board[i][S];
                            S++;
                        }
                        if(isHoeMoon(ca)){
                            if(max<ca.length){
                                max = ca.length;
                            }
                        }
                    }
                }
            }
            //지금 생각해보면, 세로 파트를 가로 파트를 복붙하는 것 보단 전치행렬을 사용하면 좀더 멋있을 것 같다.
            //세로
            for(int j=0 ; j<BOARDSIZE ; j++){
                for(int start = 0; start<BOARDSIZE ; start++){
                    for(int end = start ; end<BOARDSIZE ; end++){
                        ca = new char[end-start+1];
                        for(int k=0, S=start; k<ca.length ; k++){
                            if(end<S){
                                break;
                            }
                            ca[k] = board[S][j];
                            S++;
                        }
                        if(isHoeMoon(ca)){
                            if(max<ca.length){
                                max = ca.length;
                            }
                        }
                    }
                }
            }
            System.out.println("#"+test_case+" "+max);
        }
    }

    public static boolean isHoeMoon(char[] ca) {
        if (ca.length == 1) {
            return true;
        } else {
            for (int start = 0, end = ca.length - 1; start < ca.length / 2; start++, end--) {
                if (ca[start] != ca[end]) {
                    return false;
                }
            }
            return true;
        }
    }
}
