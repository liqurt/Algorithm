package BOJ._10950;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String line;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<t ; i++){
            line = br.readLine();
            st = new StringTokenizer(line," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = a+b;
            sb.append(c);
            if(i != t-1){
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
