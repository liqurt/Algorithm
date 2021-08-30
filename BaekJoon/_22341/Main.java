package Individual.BaekJoon._22341;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFilePath = "./src/Individual/BaekJoon/_22341/input.txt";
        System.setIn(new FileInputStream(inputFilePath));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int B=N; // y
        int A=N; // x
        int[][] paper = new int[N][N];
        for(int i=0 ; i<C ; i++){
            paper[i][1] = sc.nextInt(); //x
            paper[i][0] = sc.nextInt(); //y
        }
        for(int i=0 ; i<C ;i++){
            int y = paper[i][0];
            int x = paper[i][1];
            if(B > y && A > x){
                if(A*y>=B*x){ //Ay 가로, Bx 세로
                    B = y;
                }else{
                    A = x;
                }
            }
        }
        System.out.println(A*B);
    }
}