package baekjoon._10809;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] line = sc.nextLine().toCharArray();

        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        for (int i = 0; i < line.length; i++) {
            char item = line[i];
            if(alphabet[item-97] == -1) {
                alphabet[item - 97] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 25; i++) {
            sb.append(alphabet[i]).append(" ");
        }
        sb.append(alphabet[25]);
        System.out.println(sb);
    }
}