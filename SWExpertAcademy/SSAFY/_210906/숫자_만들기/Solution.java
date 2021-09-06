// 내가 안 짰음
// https://epser.tistory.com/6

package SSAFY._210906.숫자_만들기;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static int max;
    static int min;
    static int N;
    static int[] operator;
    static int[] numbers;
    static int dfsCount;

    public static void main(String[] args) throws IOException {
        final String inputFilePath = "./src/SSAFY/_210906/숫자_만들기/sample_input.txt";
        final File inputFile = new File(inputFilePath);

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br2 = new BufferedReader(new FileReader(inputFile));

        int T = Integer.parseInt(br2.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br2.readLine()); // N
            String[] temp = br2.readLine().split(" ");
            operator = new int[4];
            for(int i=0 ; i<4 ; i++){
                operator[i] = Integer.parseInt(temp[i]);
            } // 연산자
            numbers = new int[N];
            temp = br2.readLine().split(" ");
            for(int i=0 ; i<N ; i++){
                numbers[i] = Integer.parseInt(temp[i]);
            } // 수

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            dfsCount=0;
            dfs(0, numbers[0]);

            System.out.println("#"+test_case+" "+(max-min));
            // System.out.println("dfsCount : "+dfsCount);
        }
    }

    private static void dfs(int idx, int result) {
        dfsCount++;
        if(idx == N-1){
            if(max <= result){
                max = result;
            }
            if(result <= min){
                min = result;
            }
            return;
        }
        else{
            for(int i=0,newResult=-1 ; i<4 ; i++){
                if(operator[i] > 0){
                    operator[i]--;
                    if(i==0){
                        newResult = result + numbers[idx+1];
                    }
                    else if(i==1){
                        newResult = result - numbers[idx+1];
                    }
                    else if(i==2){
                        newResult = result * numbers[idx+1];
                    }
                    else{
                        newResult = (int) (result / numbers[idx+1]);
                    }
                    dfs(idx+1,newResult);
                    operator[i]++;
                }
            }
        }
    }
}