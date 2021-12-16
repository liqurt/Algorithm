package BOJ._1065;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int num=1 ; num<=n ; num++){
            // 각 자리의 차이가 일정한지 판단.
            char[] item = String.valueOf(num).toCharArray();
            int delimeter = 9999;
            boolean flag = false;
            for (int i = 0; i < item.length-1; i++) {
                int a = Integer.parseInt(String.valueOf(item[i]));
                int b = Integer.parseInt(String.valueOf(item[i+1]));
                if(i == 0) delimeter = a-b;
                else{
                    if(a-b != delimeter){
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
                count++;
            }
        }
        System.out.println(count);
    }
}
