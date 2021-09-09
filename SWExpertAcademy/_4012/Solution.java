package SSAFY._210907._4012;

import java.io.*;
import java.util.Scanner;

class Solution {
    static int[] ingredients;
    static int[] foodA;
    static int[] foodB;
    static int[][] synergy;
    static int minBisut;

    public static void main(String[] args) throws IOException {
        final String inputFilePath = "./src/SSAFY/_210907/요리사/sample_input.txt";
        final File inputFile = new File(inputFilePath);
        System.setIn(new FileInputStream(inputFilePath));
        Scanner sc = new Scanner(System.in);
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader(inputFile));

        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            synergy = new int[N][N];
            for(int i=0; i<N*N ; i++){
                synergy[i/N][i%N] = sc.nextInt();
            }

            // 1. 조합( nC(n/2) 에서 발생한 조합과 거기에 못들어간 조합을 구분) 이하 A[], B[]
            ingredients = new int[N];
            for(int i = 0; i< ingredients.length; i++){
                ingredients[i] = i;
            }
            foodA = new int[N/2];
            foodB = new int[N/2];

            minBisut = Integer.MAX_VALUE;
            comb(N,N/2);

            System.out.println("#"+test_case+" "+minBisut);


        }
    }

    private static void comb(int n, int r){
        if(r == 0){
            for(int i=0, k=0 ; i<ingredients.length ; i++){
                boolean flag = true;
                for(int j=0 ; j<foodA.length; j++){
                    if(ingredients[i] == foodA[j]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    foodB[k] = ingredients[i];
                    k++;
                }
            }

            // 2. 각 조합 내의 모든 시너지의 합 계산
            int matA=0;
            for(int i=0 ; i<foodA.length; i++){
                for(int j=0 ; j<foodA.length; j++){
                    matA+=synergy[foodA[i]][foodA[j]];
                }
            }
            int matB=0;
            for(int i=0 ; i<foodB.length; i++){
                for(int j=0 ; j<foodB.length; j++){
                    matB+=synergy[foodB[i]][foodB[j]];
                }
            }

            // 3. 비슷함 점수 도출 - 최소값 계산
            int bisut = Math.abs(matA-matB);
            if(bisut < minBisut){
                minBisut = bisut;
            }
        }
        else if(n<r){
            return;
        }
        else{
            foodA[r-1] = ingredients[n-1];
            comb(n-1,r-1);
            comb(n-1,r);
        }
    }

    private static void show2DArr(int arr[][]){
        for(int i=0 ; i<arr.length;i++){
            for(int j=0 ; j<arr[i].length;j++){
                System.out.printf("%5d ",arr[i][j]);
            }
            System.out.println();
        }
    }
}


