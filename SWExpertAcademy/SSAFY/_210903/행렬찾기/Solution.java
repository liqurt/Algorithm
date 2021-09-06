package SSAFY._210903.행렬찾기;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        final String inputFilePath = "./src/SSAFY/_210903/행렬찾기/input.txt";
        final File inputFile = new File(inputFilePath);

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] box = new int[n][n];
            for(int i=0 ; i<n ; i++){
                String[] str = br.readLine().split(" ");
                for(int j =0 ; j<str.length;j++){
                    box[i][j] = Integer.parseInt(str[j]);
                }
            }
            int matrixIndex = 0;
            int[][] matrix = new int[50][3];

            for(int i=0;i<n ;i+=1) {
                for(int j=0 ;j<n ; j+=1){
                    boolean flag =false;
                    if(box[i][j] != 0){// 좌상
                        if(i-1 == -1 && j-1 == -1) flag=true;
                        else if(i-1 == -1 && box[i][j-1] == 0) flag=true;
                        else if(j-1 == -1 && box[i-1][j] == 0) flag=true;
                        else if(box[i][j-1] == 0 && box[i-1][j] == 0) flag=true;

                        if(flag){
                            matrixIndex++;
                            int k=0; // 우하
                            while(true){
                                k++;
                                if(i+k<n){
                                    if(box[i+k][j] == 0) {
                                        matrix[matrixIndex][0] = k;
                                        break;
                                    }
                                }else{
                                    matrix[matrixIndex][0] = k;
                                    break;
                                }
                            }
                            k=0;
                            while(true){
                                k++;
                                if(j+k<n){
                                    if(box[i][j+k] == 0){
                                        matrix[matrixIndex][1] = k;
                                        break;
                                    }
                                }else{
                                    matrix[matrixIndex][1] = k;
                                    break;
                                }
                            }

                            // 후처리
                            for(int a=i ; a<matrix[matrixIndex][0]+i ; a++){
                                for(int b=j ; b<matrix[matrixIndex][1]+j ; b++){
                                    box[a][b] = 0;
                                }
                            }
                        }
                    }
                }
            }

            for(int i=0;i<matrix.length;i++){
                matrix[i][2] = matrix[i][0] * matrix[i][1];
            }

            // 1차 정렬 기준 : 넓이
            // 2차 정렬 기준 : 세로
            Arrays.sort(matrix, (o1,o2)->{
                if(o1[2] == o2[2]){
                    return Integer.compare(o1[0], o2[0]);
                }else{
                    return Integer.compare(o1[2], o2[2]);
                }
            });

            String result = "#"+test_case+" "+matrixIndex;
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][0] != 0){
                    result += " "+matrix[i][0]+" "+matrix[i][1];
                }
            }
            result+="\n";
            bw.write(result);
            bw.flush();
        }
        br.close();
        bw.close();
    }
}