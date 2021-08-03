package _210802.dailyHW.미로1;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
    static final int T = 10;
    static final int N = 16;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("./src/_210802/dailyHW/미로1/input.txt"));
        Scanner sc = new Scanner(System.in);


        for(int test_case = 1; test_case <= T; test_case++)
        {
            sc.nextInt(); // test_case
            final int[][] G = new int[N][N];

            //G setting
            for(int i=0 ; i<N ; i++){
                String[] temp = sc.next().split("");
                for(int j=0 ; j<N ; j++){
                    G[i][j] = Integer.parseInt(temp[j]);
                }
            }

            int[] v = {1,1};

            int result=BFS(G,v);
            System.out.println("#"+test_case+" "+result);
        }
    }

    private static int BFS(int[][] g, int[] v) {
        boolean[][] visited = new boolean[N][N];
        int[][] Q = new int[100][2];
        int f=-1,r=-1;

        r++;
        Q[r][0] = v[0];
        Q[r][1] = v[1];

        visited[v[0]][v[1]] = true;

        while(r!=f){
            int[] t = new int[2];
            f++;
            t[0] = Q[f][0];
            t[1] = Q[f][1];

            if(g[t[0]][t[1]] == 3){
                return 1;
            }else{
                int[][] uList = {{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
                int i=0;
                if((0<=t[0]-1)&&(g[t[0]-1][t[1]]!=1)){
                    uList[i][0] = t[0]-1;
                    uList[i][1] = t[1];
                    i++;
                }
                if((t[0]+1<N)&&(g[t[0]+1][t[1]]!=1)){
                    uList[i][0] = t[0]+1;
                    uList[i][1] = t[1];
                    i++;
                }
                if((0<=t[1]-1)&&(g[t[0]][t[1]-1]!=1)){
                    uList[i][0] = t[0];
                    uList[i][1] = t[1]-1;
                    i++;
                }
                if((t[1]+1<N)&&(g[t[0]][t[1]+1]!=1)){
                    uList[i][0] = t[0];
                    uList[i][1] = t[1]+1;
                    i++;
                }

                for(int j=0 ; j<4 ; j++){
                    int[] u = {uList[j][0],uList[j][1]};
                    if(u[0] == -1 && u[1] == -1) break;
                    if(!visited[u[0]][u[1]]){
                        r++;
                        Q[r][0] = u[0];
                        Q[r][1] = u[1];
                        visited[u[0]][u[1]] = true;
                    }
                }
            }

        }
        return 0;
    }

}