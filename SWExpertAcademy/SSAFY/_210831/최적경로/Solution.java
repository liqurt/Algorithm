package SSAFY._210831.최적경로;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {

    static int minSum;
    public static void main(String[] args) throws FileNotFoundException {
        final String inputFilePath = "./src/SSAFY/_210831/최적경로/input.txt";
        System.setIn(new FileInputStream(inputFilePath));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            // data 초기화
            minSum = Integer.MAX_VALUE;
            int N = sc.nextInt();
            Point[] point = new Point[N+2];
            for(int i=0 ; i<N+2 ; i++){
                int y = sc.nextInt();
                int x = sc.nextInt();
                point[i] = new Point();
                point[i].y = y;
                point[i].x = x;
            }
            int[][] dist = new int[N+2][N+2];
            for(int i=0 ; i<N+2 ; i++){
                for(int j=0 ; j<N+2 ; j++){
                    dist[i][j] = Math.abs(point[i].y - point[j].y) + Math.abs(point[i].x - point[j].x);
                }
            }

            // 방법 1 : 가까운 쪽 부터 가는 그리디
            /*
            int temp = -1;
            int temp2 = -1;
            int sum=0;
            int src = 0;
            point[0].visited = true;
            for(int count=N+1 ; 0<count ; count--){
                for(int dst = 0, minD=201 ; dst<N+2 ; dst++){
                    if(src == dst){
                    }else if(count != 1 && dst == 1){
                    }else if(!point[dst].visited){
                        int d = Math.abs(point[src].y-point[dst].y) +
                                Math.abs(point[src].x-point[dst].x);
                        if(d<minD){
                            minD = d;
                            temp = dst;
                            temp2 = minD;
                        }
                    }
                }
                point[temp].visited = true;
                sum+=temp2;
                System.out.printf("from %d ",src);
                src=temp;
                System.out.printf("to %d(cost : %d)\n",temp,temp2);
            }

            System.out.println("#"+test_case+" "+sum);
             */

            // 방법 2 : 순열 활용[2,3...N, N+1]
            // ex 65342(1-6, 6-5, 5-3... 4-2) + (2-1)
            int[] arr = new int[N];
            for(int i=0 ; i<N ; i++){
                arr[i] = i+2;
            }
            permutation(dist,arr,0,N,N);
            System.out.println("#"+test_case+" "+minSum);
        }
    }

    static void calcDist(int[][] dist, int[] arr){
        int sum=0;
        int d=-1;
        int src = 0;
        for(int i=0 ; i<arr.length ; i++){
            d = dist[src][arr[i]];
            sum+=d;
            src = arr[i];
        }
        sum+=dist[src][1];
        if(sum<minSum){
            minSum = sum;
        }
    }

    static void permutation(int[][]dist, int[] arr, int depth, int n, int r) {
        if (depth == r) {
            calcDist(dist, arr);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(dist, arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static class Point{
        int y;
        int x;
        boolean visited;
    }
}

