package baekjoon._3052;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int[] namuzi = new int[42];
        int b = 42;
        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            namuzi[a%b]++;
        }
        for (int i = 0; i < 42; i++) {
            if(namuzi[i] != 0) count++;
        }
        System.out.println(count);
    }
}
