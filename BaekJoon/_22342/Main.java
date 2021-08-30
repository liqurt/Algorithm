package Individual.BaekJoon._22342;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // String inputFilePath = "./src/Individual/BaekJoon/_22342/input.txt";
        // System.setIn(new FileInputStream(inputFilePath));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] weight = new int[N][M];
        int[][] input = new int[N][M];
        int[][] save = new int[N][M];
        int[][] output = new int[N][M];
        for(int i=0 ; i<N ; i++){
            String[] temp = sc.next().split("");
            for(int j=0 ; j<M ; j++){
                weight[i][j] = Integer.parseInt(temp[j]);
            }
            input[i][0] = 0;
            save[i][0] = 0;
            output[i][0] = weight[i][0];
        }

        for (int j=1 ; j<M ; j++){
            for(int i=0 ; i<N ; i++){
                input[i][j] = setInput(output,i,j);
                save[i][j] = setSave(input,i,j);
                output[i][j] = setOutput(save,weight,i,j);
            }
        }

        int result=-1;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(result < save[i][j]){
                    result = save[i][j];
                }
            }
        }
        System.out.println(result);
    }

    private static int setOutput(int[][] save, int[][] weight, int i, int j) {
        return save[i][j] + weight[i][j];
    }

    private static int setSave(int[][] input , int i, int j) { // 원래 save만의 계산식이 있는데 그냥 input과 똑같더라.
        return input[i][j];
    }

    private static int setInput(int[][] output, int a, int b) { // 원래 값 '들' 을 넣어야 하지만 문제를 풀다보니 그냥 그중 최댓값만 있어도 되더라
        int startY = a-b;
        int endY = a+b;
        int max = Integer.MIN_VALUE;
        if(startY<0) startY=0;
        if(output.length<endY) endY=output.length;
        for (int i=startY ; i<endY ; i++){
            for(int j=0 ; j<b ; j++){
                if(Math.abs(a-i) <= b-j){
                    int temp = output[i][j];
                    if(max < temp){
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

}