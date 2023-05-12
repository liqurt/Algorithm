package baekjoon._11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] str2 = str.split("");
        int[] num = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int item = Integer.parseInt(str2[i]);
            num[i] = item;
            sum += item;
        }
        System.out.println(sum);
    }
}
