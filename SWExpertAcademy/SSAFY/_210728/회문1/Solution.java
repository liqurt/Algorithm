package _210728.dailyHW.회문1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    private static final int T = 10;
    private static final int BOARDSIZE = 8;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/_210728/dailyHW/회문1/input.txt"));
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= T; test_case++) {
            int matchedHoeMoonLengthCount = 0;
            final int hoeMoonLength = sc.nextInt();
            char[][] board = new char[BOARDSIZE][BOARDSIZE];


            for(int i = 0; i<BOARDSIZE ; i++){
                String[] temp = sc.next().split("");
                for(int j=0 ;j<BOARDSIZE;j++){
                    board[i][j] = temp[j].charAt(0);
                }
            }

            matchedHoeMoonLengthCount = HoeMoon(matchedHoeMoonLengthCount, hoeMoonLength, board);
            Transpose(board);
            matchedHoeMoonLengthCount = HoeMoon(matchedHoeMoonLengthCount, hoeMoonLength, board);

            System.out.println("#"+test_case+" "+matchedHoeMoonLengthCount);
        }
    }

    private static int HoeMoon(int matchedHoeMoonLengthCount, int hoeMoonLength, char[][] board) {
        for(int i=0 ; i<BOARDSIZE ; i++){
            for(int start = 0; start<BOARDSIZE ; start++){
                for(int end = start+hoeMoonLength-1 ; end<BOARDSIZE ; end++){
                    char[] charArray = new char[end-start+1];
                    for(int k=0, S=start; k<charArray.length ; k++){
                        if(end<S){
                            break;
                        }
                        charArray[k] = board[i][S];
                        S++;
                    }
                    if(HoeMoonLength(charArray) == hoeMoonLength){
                        matchedHoeMoonLengthCount++;
                    }
                }
            }
        }
        return matchedHoeMoonLengthCount;
    }

    public static int HoeMoonLength(char[] charArray) {
        if (charArray.length == 1) {
            return 1;
        } else {
            for (int start = 0, end = charArray.length - 1; start < charArray.length / 2; start++, end--) {
                if (charArray[start] != charArray[end]) {
                    return 0;
                }
            }
            return charArray.length;
        }
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
