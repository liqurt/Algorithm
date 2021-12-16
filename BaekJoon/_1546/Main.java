package BOJ._1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.MIN_VALUE;
        int[] score = new int[n];
        float[] score2 = new float[n];
        while(st.hasMoreTokens()){
            int item = Integer.parseInt(st.nextToken());
            score[n-st.countTokens()-1] = item;
            if(M<item){
                M = item;
            }
        }
        float sum = 0;
        for (int i = 0; i < n; i++) {
            score2[i] = (float)score[i]/M *100;
            sum += score2[i];
        }
        System.out.println(sum/n);
    }
}
