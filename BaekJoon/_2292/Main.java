package BOJ._2292;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // 1개
        // 2*6 - 6 6개 2-7       6*0+2   ~ 6*1+1
        // 3*6 - 6 12개 8-19     6*1+2 1 ~ 6*3+1  2
        // 4*6 - 6 18개 20-37    6*3+1 2 ~ 6*6+1  3
        // 5*6 - 6 24개 38-61    6*6+2 3 ~ 6*10+1 4
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n == 1) System.out.println(1);
        else{
            int count = 2;
            int start = 0;
            int end = 1;
            int startInterval = 0, endInterval = 1;
            while (true){
                if((6*start+2 <= n) && (n <= 6*end+1)){
                    System.out.println(count);
                    break;
                }
                startInterval++;
                endInterval++;
                start+=startInterval;
                end+=endInterval;
                count++;
            }
        }

    }
}
