package BOJ._1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    static int n;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if(n<10){
            n*=10;
        }
        cycle(n);
    }

    public static void cycle(int num){
        int a = num/10;
        int b = num%10;
        int c = (a+b)%10;
        int newNum = b*10 + c;
        count++;
        if(newNum == n){
            System.out.println(count);
            exit(0);
        }else{
            cycle(newNum);
        }
    }
}

// 55 -> (5:10) -> 50 ->