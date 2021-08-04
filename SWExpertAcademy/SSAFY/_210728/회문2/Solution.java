package _210728.dailyHW.회문2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    static final int T = 10;
    static final int BOARDSIZE = 100;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/_210728/dailyHW/회문2/input.txt"));
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sc.nextInt(); // test_case, 큰 의미없음
            char[][] board = new char[BOARDSIZE][BOARDSIZE];
            for(int i = 0; i<BOARDSIZE ; i++){
                    String[] temp = sc.next().split("");
                    for(int j=0 ;j<BOARDSIZE;j++){
                        board[i][j] = temp[j].charAt(0);
                    }
            }
            int max=-1;
            max = HoeMoon(board, max);
            Transpose(board);
            max = HoeMoon(board, max);

            System.out.println("#"+test_case+" "+max);
        }
    }
    private static boolean isHoeMoon(char[] charArray) {
        if (charArray.length != 1) {
            for (int start = 0, end = charArray.length - 1; start < charArray.length / 2; start++, end--) {
                if (charArray[start] != charArray[end]) {
                    return false;
                }
            }
        }
        return true;
    }
    private static int HoeMoon(char[][] board, int max) {
        for(int i=0 ; i<BOARDSIZE ; i++){
            for(int start = 0; start<BOARDSIZE ; start++){
                for(int end = start ; end<BOARDSIZE ; end++){
                    char[] charArray = new char[end-start+1];
                    for(int k=0, S=start; k<charArray.length ; k++){
                        if(end<S){
                            break;
                        }
                        charArray[k] = board[i][S];
                        S++;
                    }
                    if(isHoeMoon(charArray)){
                        if(max<charArray.length){
                            max = charArray.length;
                        }
                    }
                }
            }
        }
        return max;
    }
    private static void Transpose(char[][] board){
        for(int i=0 ; i< board.length ; i++){
            for(int j=0 ; j<board.length ; j++){
                if(i<j){
                    char temp = board[i][j];
                    board[i][j] = board[j][i];
                    board[j][i] = temp;
                }
            }
        }
    }
}
