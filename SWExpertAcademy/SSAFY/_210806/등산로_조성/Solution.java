package _210806.dailyHW.등산로_조성;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    // 너무 어렵다.
    public static void main(String[] args) throws Exception {
        final String filePath = "./src/_210806/dailyHW/등산로_조성/sample_input.txt";
        System.setIn(new FileInputStream(filePath));
        Scanner sc = new Scanner(System.in);
        final int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            final int N = sc.nextInt(); // 3이상 8이하
            final int K = sc.nextInt(); // 1이상 5이하, 깎은 높이가 1보다 작아도 됨.
            final int[][] terrain = new int[N][N];
            int maxHeight = Integer.MIN_VALUE;
            int maxCount = 0;
            for(int i=0 ; i<N ; i++){ // 맥스봉은 5개이하
                for(int j=0 ; j<N ; j++){
                    terrain[i][j] = sc.nextInt(); // 1이상 20이하
                    if(maxHeight < terrain[i][j]){
                        maxCount = 0;
                        maxHeight = terrain[i][j];
                    }else if(maxHeight == terrain[i][j]){
                        maxCount++;
                    }
                }
            }

            int[][] maxPoints = new int[maxCount][2];
            for(int i=0,k=0; i<N ; i++){
                for(int j=0; j<N ; j++){
                    if(terrain[i][j] == maxHeight){
                        maxPoints[k][0] = i;
                        maxPoints[k][1] = j;
                        k++;
                    }
                }
            }

            for(int i=0 ; i<maxPoints.length; i++){
                test(maxPoints[i][0],maxPoints[i][1]);
            }
            // 메모이제이션 : 삽질 안 햇을때, 지점에서 부터 최대의 등산로 길이

            //출력 관련 잡다구리
            System.out.printf("#%d %d %d\n",test_case,N,K);
            System.out.println();
        }
    }

    private static void test(int i, int j) {
    }


}