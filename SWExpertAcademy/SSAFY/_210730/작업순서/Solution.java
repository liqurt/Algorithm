package _210730.dailyHW.작업순서;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static boolean[] visited;
    static String result;

    public static void main(String[] args) throws FileNotFoundException {
        final String FILE_PATH = "./src/_210730/dailyHW/작업순서/input.txt";
        final int T = 10;
        System.setIn(new FileInputStream(FILE_PATH));
        Scanner sc = new Scanner(System.in);

        for(int test_case=1; test_case<=T; test_case++) {
            int V = sc.nextInt(), E = sc.nextInt();
            int[][] board = new int[V+1][V+1];
            visited = new boolean[V+1];
            result = "";

            for(int i=0 ; i<E ; i++) { // 삐뚤빼뚤한 2차원배열 스타일로 이웃 보드 제작
                int a = sc.nextInt(), b = sc.nextInt();
                board[a][0]++;
                board[a][board[a][0]] = b;
            }
            for(int i=1 ; i<=V ; i++) { // 루트가 있는지 검사하려고 전 노드를 시작점으로 줌
                DFSRecursive(board, i);
            }

            System.out.println("#"+test_case+" "+result);
        }
    }

    private static void DFSRecursive(int[][] board, int v) {
        if(!visited[v]) { // 안들렸으면
            visited[v]=true; // 들리고
            for(int i=1 ; i<=board[v][0] ; i++)
                DFSRecursive(board, board[v][i]);
            result = v+" "+result;
        }
    }
}