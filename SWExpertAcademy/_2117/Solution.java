package SWEA._2117;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class Solution {

    static int N;
    static int M;
    static int[][] city;
    static int result;
    static int test_case;

    public static void main(String[] args) throws IOException {
        final String inputFilePath = "./src/SWEA/_2117/sample_input.txt";
        final File inputFile = new File(inputFilePath);

        System.setIn(new FileInputStream(inputFilePath));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            city = new int[N][N];

            for(int i=0 ;i<N ;i++){
                for(int j=0 ;j<N ;j++){
                    city[i][j] = sc.nextInt();
                }
            }

            for(int k= 1; k<=2*N ; k++){
                boolean nextK = false;
                for(int i= 0 ; i<N ; i++){
                    for(int j= 0 ; j<N ; j++){
                        if(k == 1 && city[i][j] == 1){
                            result = 1;
                            nextK = true;
                            break;
                        }
                        else if(k==1 && city[i][j] == 0){
                            break;
                        }
                        else{
                            int cost = getMaintenanceCost(k);
                            int[] profitAndHouse = getProfitAndHouse(i,j,k);
                            if(cost <= profitAndHouse[0] //본전치기도 포함!
                                    && result<profitAndHouse[1]){
//                                System.out.printf("RESULT UPDATE %d --> %d(%d %d %d)\n",result,profitAndHouse[1],i,j,k);
                                result = profitAndHouse[1];
                            }
                            if(result == getMaintenanceCost(k)){
                                nextK=true;
                                break;
                            }
                            // cost보다 profit이 높다면, result 갱신
                            // result가 5면, 다음 K로 넘어간다.
                        }
                    }
                    if(nextK)
                        break;
                }
            }

            System.out.printf("#%d %d\n",test_case,result);

            // k = 1 일때, result의 최대값 = 1
            // k = 2 일때, result의 최대값 = 5
            // k = 3 일때, result의 최대값 = 13
            // k = 4 일때, result의 최대값 = 25
            // k = 5 일때, result의 최대값 = 41
            // k = 6 일때, result의 최대값 = 61
            // k = 7 일때, result의 최대값 = 85
        }
    }

    private static int[] getProfitAndHouse(int i, int j, int k) {
        int[] profitAndHouse = {0,0};
        int profit=0;
        int house=0;
        for(int ii=i-(k-1) ; ii<=i+(k-1) ; ii++){
            if(0 <= ii && ii <= N-1){
                for(int jj=j-(k-1) ; jj<=j+(k-1) ; jj++){
                    if(0 <= jj && jj <= N-1){
                        if((city[ii][jj]==1 && (Math.abs(ii-i) + Math.abs(jj-j) < k))){
                            profit+=M;
                            house++;
                        }
                    }
                }
            }
        }
        profitAndHouse[0] = profit;
        profitAndHouse[1] = house;
        return profitAndHouse;
    }

    private static int getMaintenanceCost(int k){
        return k*k+(k-1)*(k-1);
    }
}


