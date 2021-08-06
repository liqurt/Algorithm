package _210806.dailyHW.추억의_2048게임;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {

    public static void main(String[] args) throws Exception {
        final String filePath = "./src/_210806/dailyHW/추억의_2048게임/s_input.txt";
        System.setIn(new FileInputStream(filePath));
        Scanner sc = new Scanner(System.in);
        final int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            final int N = sc.nextInt();
            final String direction = sc.next();
            int[][] board = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    board[i][j] = sc.nextInt();
                }
            }

            board = move(board, direction);

            System.out.println("#"+test_case);
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }



        }
    }

    //N == board.length
    private static int[][] move(int[][] board, String direction) {
        final int N = board.length;
        if("down".equals(direction)){
            for(int i=0 ; i<N/2 ;i++){
                for(int j=0 ; j<N ; j++){
                    int temp = board[i][j];
                    board[i][j] = board[N-i-1][j];
                    board[N-i-1][j] = temp;
                }
            }
        }
        else if("left".equals(direction)){
            for(int i=0 ; i<N ;i++){
                for(int j=0 ; j<N ; j++){
                    if(i<j){
                        int temp = board[i][j];
                        board[i][j] = board[j][i];
                        board[j][i] = temp;
                    }
                }
            }
        }
        else if("right".equals(direction)){
            for(int i=0 ; i<N ;i++){
                for(int j=0 ; j<N ; j++){
                    if(i+j < N-1){
                        int temp = board[i][j];
                        board[i][j] = board[N-1-j][N-1-i];
                        board[N-1-j][N-1-i] = temp;
                    }
                }
            }
        }
        // up기준
        for(int i=0; i<N ;i++){
            int zeroCount=0;
            for(int j=0; j<N ; j++)
                if (board[j][i] == 0)
                    zeroCount++;
            int[] arr = new int[N - zeroCount];
            for(int j=0,k=0 ; j<N ; j++){
                if(board[j][i] != 0){
                    arr[k++] = board[j][i];
                }
            }
            for(int a=0 ; a<arr.length-1 ; a++){
                if(arr[a] == arr[a+1]){
                    arr[a]*=2;
                    arr[a+1] = 0;
                    a++;
                }
            }

            zeroCount = 0;
            for(int a=0; a<arr.length ; a++)
                if(arr[a] == 0)
                    zeroCount++;
            int[] arr2 = new int[arr.length-zeroCount];
            for(int a=0,k=0 ; a<arr.length ; a++){
                if(arr[a] != 0){
                    arr2[k++] = arr[a];
                }
            }
            for(int a=0 ; a<N ; a++){
                board[a][i] = 0;
            }
            for(int a=0 ; a<arr2.length ; a++){
                board[a][i] = arr2[a];
            }
        }

        if("down".equals(direction)){
            for(int i=0 ; i<N/2 ;i++){
                for(int j=0 ; j<N ; j++){
                    int temp = board[i][j];
                    board[i][j] = board[N-i-1][j];
                    board[N-i-1][j] = temp;
                }
            }
        }
        else if("left".equals(direction)){
            for(int i=0 ; i<N ;i++){
                for(int j=0 ; j<N ; j++){
                    if(i<j){
                        int temp = board[i][j];
                        board[i][j] = board[j][i];
                        board[j][i] = temp;
                    }
                }
            }
        }
        else if("right".equals(direction)){
            for(int i=0 ; i<N ;i++){
                for(int j=0 ; j<N ; j++){
                    if(i+j < N-1){
                        int temp = board[i][j];
                        board[i][j] = board[N-1-j][N-1-i];
                        board[N-1-j][N-1-i] = temp;
                    }
                }
            }
        }

        return board;
    }

}