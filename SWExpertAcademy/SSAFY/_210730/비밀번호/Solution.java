package _210730.dailyHW.비밀번호;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        final int T = 10;
        System.setIn(new FileInputStream("./src/_210730/dailyHW/비밀번호/input.txt"));
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= T; test_case++) {
            //입력관련 어쩌구
            int N = sc.nextInt(); // message.length와 같다
            String[] temp = sc.next().split("");
            int[] message = new int[N];
            for(int i=0 ; i<N ;i++){
                message[i] = Integer.parseInt(temp[i]);
            }

            int[] stack = new int[N];
            int top = -1;

            for(int i = 0 ;i<N ;i++){
                // 스택 맨위 숫자랑 지금 읽은 숫자랑 같으면
                if(top != -1 && message[i] == stack[top]){
                    stack[top] = -1; // 팝
                    top--;
                }else{
                    //아니면 푸시
                    stack[++top] = message[i];
                }
            }

            //출력관련 어쩌구
            String result="";
            for(int i = 0 ; i<top+1 ; i++){
                result+=stack[i];
            }
            System.out.println("#"+test_case+" "+result);
        }
    }
}