package BOJ._10951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str="";

        while( (str = br.readLine()) != null){
            st = new StringTokenizer(str, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = a+b;
            sb.append(c).append("\n");
        }
        String temp = sb.toString();
        sb.deleteCharAt(temp.length()-1);
        System.out.println(sb);
    }
}
