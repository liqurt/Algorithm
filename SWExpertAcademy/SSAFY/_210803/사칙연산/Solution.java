package _210803.dailyHW.사칙연산;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static String[] data;
    static int[][] tree;
    static int N;

    public static void main(String[] args) throws Exception
    {
        System.setIn(new FileInputStream("./src/_210803/dailyHW/사칙연산/input.txt"));
        Scanner sc = new Scanner(System.in);
        final int T = 10;

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(sc.nextLine());
            data = new String[N + 1];
            tree = new int[N+1][3];
            for(int i=0 ; i<N ; i++){
                String[] temp = sc.nextLine().split(" ");
                data[Integer.parseInt(temp[0])] = temp[1];
                if(3<=temp.length){
                    tree[Integer.parseInt(temp[0])][0] = Integer.parseInt(temp[2]);
                    tree[Integer.parseInt(temp[2])][2] = Integer.parseInt(temp[0]);
                }
                if(4<=temp.length){
                    tree[Integer.parseInt(temp[0])][1] = Integer.parseInt(temp[3]);
                    tree[Integer.parseInt(temp[3])][2] = Integer.parseInt(temp[0]);
                }
            }

            System.out.println("#"+test_case+" "+postOrderTraversal(1));
        }
    }

    private static boolean isInteger(String s){
        try{
            int temp = Integer.parseInt(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    private static int postOrderTraversal(int t){
        if(0<t && t<=N){
            postOrderTraversal(tree[t][0]);
            postOrderTraversal(tree[t][1]);
            //q.add(data[t]);
            if(!isInteger(data[t]) && (isInteger(data[tree[t][0]])) && (isInteger(data[tree[t][1]]))){
                int a = Integer.parseInt(data[tree[t][0]]);
                int b = Integer.parseInt(data[tree[t][1]]);
                String result="";
                switch (data[t]){
                    case "+": result = Integer.toString(a+b); break;
                    case "-": result = Integer.toString(a-b); break;
                    case "*": result = Integer.toString(a*b); break;
                    case "/": result = Integer.toString(a/b); break;
                }
                data[t] = result;
            }
        }
        if(t == 1){
            return Integer.parseInt(data[t]);
        }
        return -1;
    }



}