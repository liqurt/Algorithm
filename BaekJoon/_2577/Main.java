package BOJ._2577;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int abc = a*b*c;
//        v1(abc);
        v2(abc);
    }

    public static void v1(int abc){
        Long start = System.currentTimeMillis();
        String abcstr = String.valueOf(abc);
        char[] abcCharArr = abcstr.toCharArray();
        int[] count = new int[10];
        for(int i=0 ; i<abcCharArr.length ; i++){
            char item = abcCharArr[i];
            if(item == '0') count[0]++;
            else if(item == '1') count[1]++;
            else if(item == '2') count[2]++;
            else if(item == '3') count[3]++;
            else if(item == '4') count[4]++;
            else if(item == '5') count[5]++;
            else if(item == '6') count[6]++;
            else if(item == '7') count[7]++;
            else if(item == '8') count[8]++;
            else if(item == '9') count[9]++;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start+"ms");
    }

    public static void v2(int abc){
        Long start = System.currentTimeMillis();
        int[] count = new int[10];
        while(0 < abc){
            int last = abc%10;
            count[last]++;
            abc/=10;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start+"ms");
    }
}
