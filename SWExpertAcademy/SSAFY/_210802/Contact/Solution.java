package _210802.dailyHW.Contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

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
            int[][] G = new int[SIZE][SIZE];

            for(int i=0 ; i<N ; i+=2) {
                int src = sc.nextInt();
                int dst = sc.nextInt();
                G[src][0] ++; // g[src][0] : src 에서 다른 노드로 갈수있는 경우의 수, '경로' 가 '1개 더' 생겼다!
                G[src][G[src][0]] = dst; // '몇 번째 경로' 인지, '어디' 로 가는지
            }

            int result = BFS(G,START);
            System.out.println("#"+test_case+" "+result);
        }
    }

    // 방법1 : v를 큐에 넣을때 레벨도 함꼐 집어넣음(2,0)(15,1)(7,1)...(10,3),(8,3),(17,3)
    // 방법2(채택) : delimiter(ex:'-1')를 집어넣음 [2,-1,15,7,-1,4,1,-1,10,8,17,-1]
    private static int BFS(int[][] g, int v) {
        int ans = -1;
        boolean[] visited = new boolean[g.length];
        int[] Q = new int[g.length];
        int f=-1,r=-1;

        Q[++r] = v;
        Q[++r] = -1;
        visited[v] = true;

        while(true){
            int t = Q[++f];
            if(ans < t){
                ans = t;
            }
            if(t == -1){
                if(f == r){
                    break; // 큐가 비었다면
                }
                else{
                    ans = Q[++r] = -1;
                    continue;
                }
            }

            for(int i=0; i<g[t][0]; i++){ // g[t][0] : t에서 다른 노드로 갈수있는 경우의 수
                if(!visited[g[t][i+1]]){ // g[t][1] - t에서 다른 노드로 가는 1번째 경우, 값은 목적지(이웃)
                    visited[g[t][i+1]] = true;
                    Q[++r] = g[t][i+1];
                }
            }
        }
        return ans;
    }
}