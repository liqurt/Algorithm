package SWEA._7465;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Solution {

    static int N,M;
    static boolean[] visited;
    static int[][] G;

    static String temp;
    static ArrayList<String> connect;


    public static void main(String[] args) throws IOException {
        final String inputFilePath = "./src/SWEA/_7465/s_input.txt";
        final File inputFile = new File(inputFilePath);

        System.setIn(new FileInputStream(inputFilePath));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            visited = new boolean[N+1];
            G = new int[N+1][N+1];
            connect = new ArrayList<>();
            int result = 0;

            for(int i=0 ; i<M ; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                G[a][0]++;
                G[a][G[a][0]] = b;

                int temp=a;
                a=b;
                b=temp;
                G[a][0]++;
                G[a][G[a][0]] = b;

            }

//            show2DArr(G);
            if(M == 0){
                result = N;
            }
            else if(M == 1){
                result = N-1;
            }
            else{
                for(int i=1 ; i<=N ; i++){
                    temp = "";
                    DFSr(i);
                    if(temp.length() != 0)
                        connect.add(temp);
                }
                result = connect.size();
//                System.out.println(connect);
            }

            System.out.printf("#%d %d\n",test_case,result);
//            System.out.println("-----------------------------");
        }
    }

    private static void DFSr(int v) {
        if(!visited[v]){
            visited[v] = true;
            temp += String.valueOf(v);
        }

        for(int i=1 ; i<=G[v][0] ; i++){
            if(!visited[G[v][i]]){
                DFSr(G[v][i]);
            }
        }
    }

    private static void show2DArr(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%2d ", anInt);
            }
            System.out.println();
        }
    }

}


