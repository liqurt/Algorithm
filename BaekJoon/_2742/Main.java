package BOJ._2742;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=n ; 1<i ; i--){
            sb.append(i).append("\n");
        }
        sb.append(1);
        System.out.println(sb);
    }
}