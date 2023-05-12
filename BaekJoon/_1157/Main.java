package baekjoon._1157;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int[] count = new int[26];

        Scanner sc = new Scanner(System.in);
        char[] line = sc.nextLine().toCharArray();

        for(int i=0 ; i<line.length ; i++){
            char item = line[i];
            if(65<=item && item<=90){
                count[item-65]++;
            }
            else if(97<=item && item<=122){
                count[item-97]++;
            }
        }

        char result = '!';
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if(max < count[i]){
                max = count[i];
                maxIndex = i;
                int s = maxIndex+65;
                result = (char) (s);
            }else if(max == count[i]){
                result = '?';
            }
        }

        System.out.println(result);
    }
}
