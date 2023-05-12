package baekjoon._5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        int sum = 0;
        for (int i = 0; i < line.length; i++) {
            char item = line[i];
            if(item <= 'C'){
                sum+=3;
            }else if(item <= 'F'){
                sum+=4;
            }else if(item <= 'I'){
                sum+=5;
            }else if(item <= 'L'){
                sum+=6;
            }else if(item <= 'O'){
                sum+=7;
            }else if(item <= 'S'){
                sum+=8;
            }else if(item <= 'V'){
                sum+=9;
            }else if(item <= 'Z'){
                sum+=10;
            }
        }
        System.out.println(sum);
    }
}
