package _210809.test;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

class P2 {
    static boolean[][] friends;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/_210809/test/input.txt"));
        Scanner sc = new Scanner(System.in);
        final int T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            final int groupCount = sc.nextInt();
            int maxNum=-1;
            friends = new boolean[101][101];

            //입력
            for(int i=0 ; i<groupCount ; i++){
                int memberCount = sc.nextInt();
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0, man=-1 ; j<memberCount ; j++){
                    man = sc.nextInt();
                    temp.add(man);
                }

                for(int a = 0 ; a<temp.size() ; a++){ // 친구목록 업데이트
                    for(int b = a ; b<temp.size() ; b++){
                        if(a!=b){
                            friends[temp.get(a)][temp.get(b)] = true;
                            friends[temp.get(b)][temp.get(a)] = true;
                        }
                    }
                }


            }
            for(int i=1 ; i<=100 ; i++){ // DFS 재귀를 돌려 맥스값을 도출
                depth = 0;
                visited = new boolean[101];
                dfs(i);
                if(maxDepth < depth){
                    maxDepth = depth;
                }
            }

            // 출력
            System.out.println("#"+test_case+" "+maxDepth);
        }
    }

    static int depth;
    static int maxDepth;

    private static void dfs(int v){
        visited[v] = true;
        depth++;

        ArrayList<Integer> neghibor = new ArrayList<>();
        for(int i=1 ; i<=100 ; i++){ // 친구면
            if(friends[v][i]){
                neghibor.add(i);
            }
        }

        for(int i=0 ; i<neghibor.size();i++){ // 친구가 방문 안했으면 그래프에 추가
            if(!visited[neghibor.get(i)]){
                dfs(i);
            }
        }
    }
}