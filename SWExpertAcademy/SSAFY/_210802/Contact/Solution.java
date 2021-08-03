package _210802.dailyHW.Contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

// 24 2
// 2 7 11 6 6 2 2 15 15 4 4 2 4 10 7 1 1 7 1 8 1 17 3 22


//24 2
//1 17 3 22 1 8 1 7 7 1 2 7 2 15 15 4 6 2 11 6 4 10 4 2
public class Solution {

    static final int T = 10;
    static final int SIZE = 101;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("./src/_210802/dailyHW/Contact/input.txt"));
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= T; test_case++)
        {
            final int N = sc.nextInt();
            final int START = sc.nextInt();
            boolean[][] G = new boolean[SIZE][SIZE];

            for(int i=0 ; i<N ; i+=2) {
                int src = sc.nextInt();
                int dst = sc.nextInt();
                G[src][dst] = true;
            }

            System.out.print("#"+test_case+"\n");
            int result = BFS(G,START);
            System.out.println();
        }
    }

    private static int BFS(boolean[][] g, int v) {
        int[] step = new int[g.length];
        int stemNum = 1;
        boolean[] visited = new boolean[g.length];
        int[] Q = new int[g.length];
        int f=-1,r=-1;

        r++;
        Q[r] = v;

        visited[v] = true;
        step[v] = stemNum;

        while(r!=f){
            int t = Q[++f];

            int[] uList = new int[SIZE];
            int uListIdx = 0;
            for(int i=0; i<SIZE ; i++){
                if(g[t][i]){
                    uList[uListIdx++] = i;
                }
            }

            for(int i=0,u ; i<uListIdx ; i++){
                u = uList[i];
                if(!visited[u]){
                    Q[++r] = u;
                    visited[u] = true;
                }
            }
            System.out.println();
        }
        return 0;
    }
}