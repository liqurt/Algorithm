package BOJ._2439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int k= 1 ; k<=n-i ; k++){
                sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            if(i != n)
                sb.append("\n");
        }
        System.out.println(sb);
    }
}
