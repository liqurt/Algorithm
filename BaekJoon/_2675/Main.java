package BOJ._2675;

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
        for(int tc = 0 ; tc<t ; tc++){
            st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken());
            char[] s = st.nextToken().toCharArray();
            for(int i=0 ; i<s.length ; i++){
                for(int j=0 ; j<r ; j++){
                    sb.append(s[i]);
                }
            }
            if(tc != t-1){
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
