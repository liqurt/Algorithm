package _210805.dailyHW.최대_상금;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    static int max;

    public static void main(String[] args) throws Exception {
        final String filePath = "./src/_210805/dailyHW/최대_상금/input.txt";
        System.setIn(new FileInputStream(filePath));
        Scanner sc = new Scanner(System.in);

        final int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            String[] temp =sc.next().split("");
            final int[] arr = new int[temp.length];
            for(int i = 0; i <arr.length ; i++){
                arr[i] = Integer.parseInt(temp[i]);
            }
            int n = arr.length;
            int depth = sc.nextInt();

            final int[][] nC2 = new int[nCr(n,2)][2];
            nC2Maker(nC2, n);
            max = -1;
            // 답만 나오면 된다지만, 10중 for 문은 너무 추잡스럽다, 10중 for 문이라 시간도 엄청 오래걸림 ㄹㅇ

            if(depth == 1){
                for(int a=0 ;a < nC2.length ; a++){
                    int[] test = Arrays.copyOf(arr,arr.length);
                    swap(test, nC2[a][0], nC2[a][1]);
                    int resultTemp = calc(test);
                    if(max<resultTemp){
                        max = resultTemp;
                    }
                }
            }
            else if(depth == 2){
                for(int a=0 ;a < nC2.length ; a++) {
                    for (int b = 0; b < nC2.length; b++) {
                        int[] test = Arrays.copyOf(arr,arr.length);
                        swap(test, nC2[a][0], nC2[a][1]);
                        swap(test, nC2[b][0], nC2[b][1]);
                        int resultTemp = calc(test);
                        if (max < resultTemp) {
                            max = resultTemp;
                        }
                    }
                }
            }
            else if(depth == 3){
                for(int a = 0 ; a<nC2.length ;a++){
                    for(int b=0 ;b<nC2.length ; b++) {
                        for (int c = 0; c<nC2.length; c++) {
                            int[] test = Arrays.copyOf(arr,arr.length);
                            swap(test, nC2[a][0], nC2[a][1]);
                            swap(test, nC2[b][0], nC2[b][1]);
                            swap(test, nC2[c][0], nC2[c][1]);
                            int resultTemp = calc(test);
                            if (max < resultTemp) {
                                max = resultTemp;
                            }
                        }
                    }
                }
            }

            else if(4 <= depth){
                for(int a = 0 ; a<nC2.length ;a++){
                    for(int b=0 ;b<nC2.length ; b++) {
                        for (int c = 0; c<nC2.length; c++) {
                            for(int d=0 ; d<nC2.length ; d++){
                                int[] test = Arrays.copyOf(arr,arr.length);
                                swap(test, nC2[a][0], nC2[a][1]);
                                swap(test, nC2[b][0], nC2[b][1]);
                                swap(test, nC2[c][0], nC2[c][1]);
                                swap(test, nC2[d][0], nC2[d][1]);
                                int resultTemp = calc(test);
                                if (max < resultTemp) {
                                    max = resultTemp;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("#"+test_case+" "+max);
        }
    }

    public static void nC2Maker(int[][] nC2, int n){
        int nC2Index = 0;
        for(int i= 0 ;i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(i < j){
                    nC2[nC2Index][0] = i;
                    nC2[nC2Index][1] = j;
                    nC2Index++;
                }
            }
        }
    }

    public static int nCr(int n, int r){
        return factorial(n)/(factorial(n-r)*factorial(r));
    }

    public static int factorial(int n){
        if(n == 1) return 1;
        return n*factorial(n-1);
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int calc(int[] money){
        int result = 0;
        for(int i = 0;  i< money.length ; i++){
            result+= money[i] * power(10, money.length-i-1);
        }
        return result;
    }

    public static int power(int under, int upper){
        if(upper == 0){
            return 1;
        }else{
            return under * power(under, upper-1);
        }
    }
}