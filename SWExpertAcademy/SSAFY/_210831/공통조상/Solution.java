package SSAFY._210831.공통조상;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    static boolean[] visitedR;
    static int count;

    public static void main(String[] args) throws FileNotFoundException {
        final String inputFilePath = "./src/SSAFY/_210831/공통조상/input.txt";
        System.setIn(new FileInputStream(inputFilePath));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int[][] tree = new int[V+1][3];
            for(int i=0 ; i<E ; i++){
                int temp1 = sc.nextInt();
                int temp2 = sc.nextInt();
                if(tree[temp1][0] == 0){
                    tree[temp1][0] = temp2;
                }else{
                    tree[temp1][1] = temp2;
                }
                tree[temp2][2] = temp1;
            }

            ArrayList<Integer> v1Ancestor = new ArrayList<>();
            ArrayList<Integer> v2Ancestor = new ArrayList<>();

            while(true){
                 v1 = tree[v1][2];
                 v1Ancestor.add(v1);
                 if(v1 == 0) break;
            }
            while(true){
                v2 = tree[v2][2];
                v2Ancestor.add(v2);
                if(v2 == 0) break;
            }

            int result1 = -1;
            int result2;
            boolean isDone = false;
            for(int i=0 ; i<v1Ancestor.size() ; i++){
                int v1A = v1Ancestor.get(i);
                for(int j=0 ; j<v2Ancestor.size() ; j++){
                    int v2A = v2Ancestor.get(j);
                    if(v1A == v2A){
                        result1 = v1A;
                        isDone = true;
                        break;
                    }
                }
                if(isDone){
                    break;
                }
            }
            visitedR = new boolean[V+1];
            count = 0;
            if(result1 == -1){
                System.out.println("오묘한 에러 발생");
            }
            DFSr(result1, tree);
            result2=count;
            System.out.println("#"+test_case+" "+result1+" "+result2);
        }
    }

    private static void DFSr(int v, int[][] tree){
        visitedR[v] = true; // 나 먼저.
        count++;

        int child=0;
        if(tree[v][1] != 0) child=2;
        else if(tree[v][0] != 0) child=1;

        for(int i=0 ; i<child ; i++){
            if(!visitedR[tree[v][i]]){ // 이웃중 안들렸다 싶으면
                DFSr(tree[v][i],tree); // 들어가게함
            }
        }
    }

}

