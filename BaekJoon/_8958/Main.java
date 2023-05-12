package baekjoon._8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int score=0;
            int localScore = 1;
            char[] ox = br.readLine().toCharArray();
            for (int j = 0; j < ox.length; j++) {
                char item = ox[j];
                if(item == 'O'){
                    score += localScore;
                    localScore++;
                }
                else localScore = 1;
            }
            System.out.println(score);
        }
    }
}
