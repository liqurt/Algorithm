package _210729.dailyHW.괄호_짝짓기;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static final int T = 10;

    public static void main(String[] args) throws Exception
    {
        System.setIn(new FileInputStream("./src/_210729/dailyHW/괄호_짝짓기/input.txt"));
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sc.nextInt(); // message.length와 같음
            char[] message = sc.next().toCharArray();
            System.out.println("#"+test_case+" "+isValid(message));
        }
    }

    public static int isValid(char[] msg){
        int top = -1;
        char[] stack = new char[msg.length];
        for(int i=0 ; i<msg.length ; i++){
            if((msg[i] == '(') || (msg[i] == '{') ||(msg[i] == '[') ||(msg[i] == '<')){
                stack[++top] = msg[i];
            }else{
                if(top == -1){
                    return 0;
                }else{
                    // 짝이 맞는지 아닌지 체크
                    if(stack[top]!='(' && msg[i] == ')'){
                        return 0;
                    }else if(stack[top]!='{' && msg[i] == '}'){
                        return 0;
                    }else if(stack[top]!='[' && msg[i] == ']'){
                        return 0;
                    }else if(stack[top]!='<' && msg[i] == '>'){
                        return 0;
                    }
                    top--;
                }
            }
        }
        if(top != -1){
            return 0;
        }else{
            return 1;
        }
    }
}