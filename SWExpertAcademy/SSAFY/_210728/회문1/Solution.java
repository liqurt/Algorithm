package _210728.dailyHW.회문1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    private static final int T = 10;
    private static final int BOARDSIZE = 8;

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("./src/_210728/dailyHW/회문1/input.txt"));
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int matchedHoeMoonLengthCount = 0;
            int hoeMoonLength = sc.nextInt();
            char[][] board = new char[BOARDSIZE][BOARDSIZE];
            char[] ca;

            for(int i = 0; i<BOARDSIZE ; i++){
                String[] temp = sc.next().split("");
                for(int j=0 ;j<BOARDSIZE;j++){
                    board[i][j] = temp[j].charAt(0);
                }
            }

            // 가로
            for(int i=0 ; i<BOARDSIZE ; i++){
                for(int start = 0; start<BOARDSIZE ; start++){
                    for(int end = start+hoeMoonLength-1 ; end<BOARDSIZE ; end++){
                        ca = new char[end-start+1];
                        for(int k=0, S=start; k<ca.length ; k++){
                            if(end<S){
                                break;
                            }
                            ca[k] = board[i][S];
                            S++;
                        }
                        if(HoeMoonLength(ca) == hoeMoonLength){
                            matchedHoeMoonLengthCount++;
                        }
                    }
                }
            }

            // 세로
            for(int i=0 ; i<BOARDSIZE ; i++){
                for(int start = 0; start<BOARDSIZE ; start++){
                    for(int end = start+hoeMoonLength-1 ; end<BOARDSIZE ; end++){
                        ca = new char[end-start+1];
                        for(int k=0, S=start; k<ca.length ; k++){
                            if(end<S){
                                break;
                            }
                            ca[k] = board[S][i];
                            S++;
                        }
                        if(HoeMoonLength(ca) == hoeMoonLength){
                            matchedHoeMoonLengthCount++;
                        }
                    }
                }
            }

            System.out.println("#"+test_case+" "+matchedHoeMoonLengthCount);
        }
    }

    public static int HoeMoonLength(char[] ca) {
        if (ca.length == 1) {
            return 1;
        } else {
            for (int start = 0, end = ca.length - 1; start < ca.length / 2; start++, end--) {
                if (ca[start] != ca[end]) {
                    return 0;
                }
            }
            return ca.length;
        }
    }
}
