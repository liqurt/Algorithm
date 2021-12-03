package SWEA._1865;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
    static int globalDepth;
    static double globalScore;
    static boolean[] globalVisited;
    static Stack<Integer> globalStack;
    static int globalN;
    static int[][] globalBoard;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            //입력
            globalN = Integer.parseInt(br.readLine());
            globalBoard = new int[globalN][globalN];
            for(int i=0 ; i<globalN ; i++){
                st = new StringTokenizer(br.readLine()," ");
                int j=0;
                while(st.hasMoreTokens()){
                    globalBoard[i][j++] = Integer.parseInt(st.nextToken());
                }
            }

            //입력 확인
//            showInput(N, globalBoard);

            //알고리즘
            globalVisited = new boolean[globalN];
            globalStack = new Stack<>();
            globalDepth = 0;
            globalScore = 0;
            DFS(1);
            sb.append("#").append(test_case).append(" ").append(String.format("%.6f",globalScore*100)).append("\n");
        }
        System.out.println(sb);
    }

    public static void DFS(double score){
        for(int item=0 ; item<globalN ;item++){
            if(!globalVisited[item]){
                int nowScore = globalBoard[globalDepth][item];
//                System.out.println(globalStack+":"+score);
                if(nowScore != 0) {
                    score *= (double) nowScore / 100;
                    if (globalScore < score) {
                        globalStack.push(item);
                        globalVisited[item] = true;
                        globalDepth++;
                        DFS(score);
                        globalDepth--;
                        globalVisited[item] = false;
                        globalStack.pop();
                    }
                    score /= (double) nowScore/100;
                }

            }
        }
        if (globalStack.size() == globalN){
            if(globalScore<score){
                globalScore = score;

//                System.out.println(globalStack+":"+score+"!");
            }
        }
    }

//    public static void showInput(int n, int[][] board){
//        System.out.println(n);
//        for(int i=0 ; i< board.length;i++){
//            for(int j=0 ; j< board.length;j++){
//                System.out.print(board[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }

}

/*
1
5
92 43 0 95 89
84 88 43 34 55
17 97 96 21 83
10 34 10 56 15
22 40 98 33 1
* */
