package _210803.dailyHW.중위순회;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static char[] data;
    static int[][] tree;
    static int N;
    static String result;
    public static void main(String[] args) throws Exception
    {
        System.setIn(new FileInputStream("./src/_210803/dailyHW/중위순회/input.txt"));
        Scanner sc = new Scanner(System.in);
        final int T = 10;

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(sc.nextLine());
            data = new char[N+1];
            tree = new int[N+1][3];
            for(int i=0 ; i<N ; i++){
                String[] temp = sc.nextLine().split(" ");
                data[Integer.parseInt(temp[0])] = temp[1].charAt(0);
                if(3<=temp.length){
                    tree[Integer.parseInt(temp[0])][0] = Integer.parseInt(temp[2]);
                    tree[Integer.parseInt(temp[2])][2] = Integer.parseInt(temp[0]);
                }
                if(4<=temp.length){
                    tree[Integer.parseInt(temp[0])][1] = Integer.parseInt(temp[3]);
                    tree[Integer.parseInt(temp[3])][2] = Integer.parseInt(temp[0]);
                }
            }
            int t = 1;
            result ="";
            inOrderTraversal(t);
            System.out.println("#"+test_case+" "+result);
        }
    }

    private static void inOrderTraversal(int t) {
        if(0<t && t<=N){
            inOrderTraversal(tree[t][0]);
            result+=data[t];
            inOrderTraversal(tree[t][1]);
        }
    }

}