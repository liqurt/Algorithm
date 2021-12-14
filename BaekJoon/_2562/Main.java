package BOJ._2562;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 1; i <= 9; i++) {
            int item = sc.nextInt();
            if(max<item){
                max = item;
                maxIndex = i;
            }
        }
        System.out.print(max+"\n"+maxIndex);
    }
}
