package BOJ._11021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=1 ; tc<=t ; tc++){
           st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int c = a+b;
           sb.append("Case #").append(tc).append(": ").append(c);
           if(tc != t){
               sb.append("\n");
           }
        }
        System.out.println(sb);
    }
}
