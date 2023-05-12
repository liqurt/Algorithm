package baekjoon._2908;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        a = convert(a);
        b = convert(b);
        int result = -1;
        if(a>b) result = a;
        else if(a<b) result = b;
        System.out.println(result);
    }

    private static int convert(int num) {
        StringBuilder sb = new StringBuilder();
        while(true){
            int n = num%10;
            num/=10;
            sb.append(n);
            if (num == 0) break;
        }
        return Integer.parseInt(sb.toString());
    }
}
