package _210730.dailyHW.계산기3;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        final int T = 10;
        System.setIn(new FileInputStream("./src/_210730/dailyHW/계산기3/input.txt"));
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= T; test_case++) {
            //입력관련 어쩌구
            int N = sc.nextInt(); // message.length와 같다
            String[] infix = sc.next().split("");

            String[] postfix = infixToPostfix(infix);
            int result = calcPostfix(postfix);
            //출력관련 어쩌구
            System.out.println("#"+test_case+" "+ result);
        }
    }

    private static int calcPostfix(String[] postfix) {
        int howManyNullCount = 0;
        for(int i = 0 ;i<postfix.length;i++){
            if(postfix[i] == null){
                howManyNullCount++;
            }
        }
        String[] stack = new String[postfix.length-howManyNullCount];
        int top = -1;

        for(int i = 0 ;i<stack.length;i++){
            if(isInteger(postfix[i])){ // 숫자면 스택에 넣음
                stack[++top] = postfix[i];
            }else{ // 연산자면
                int b = Integer.parseInt(stack[top--]); // 첫 팝 : 무조건 숫자일수밖에 없음
                int a = Integer.parseInt(stack[top--]); // 둘째 팝 : 무조건 숫자일수밖에 없음
                switch (postfix[i]){
                    case "+":
                        stack[++top] = String.valueOf(a+b);
                        break;
                    case "-":
                        stack[++top] = String.valueOf(a-b);
                        break;
                    case "*":
                        stack[++top] = String.valueOf(a*b);
                        break;
                    case "/":
                        stack[++top] = String.valueOf(a/b);
                        break;
                }
            }
        }
        return Integer.parseInt(stack[top]);
    }

    private static boolean isInteger(String s){
        try{
            int a = Integer.parseInt(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private static String[] infixToPostfix(String[] infix){
        String[] stack = new String[infix.length];
        int top = -1;
        String[] postfix = new String[infix.length];
        int j=0;

        for (String token : infix) {
            if (isInteger(token)) { // 숫자 : 바로 포스트픽스에 넣음
                postfix[j++] = token;
            } else {
                switch (token) {
                    case "(": // 여는 괄호 : 스택에 넣음
                        stack[++top] = token;
                        break;
                    case ")": // 닫는 괄호 : 여는 괄호가 나올때 까지, 스택에서 pop 한걸 포스트픽스에 넣음
                        while (true) {
                            if (stack[top].equals("(")) {
                                top--;
                                break;
                            } else {
                                postfix[j++] = stack[top--];
                            }
                        }
                        break;
                    case "+": // 더하기 : 스택 맨 위가 더하기, 곱하기면 --> 스택 맨 위 연산자를 포스트픽스에 넣음
                        if (stack[top].equals("+") || stack[top].equals("*")) {
                            postfix[j++] = stack[top--];
                        }
                        stack[++top] = token; // 나는 스택에 들어감
                        break;
                    case "*":// 곱하기 : 스택 맨 위가 곱하기면 --> 스택 맨 위 연산자를 포스트픽스에 넣음
                        if (stack[top].equals("*")) {
                            postfix[j++] = stack[top--];
                        }
                        stack[++top] = token; // 나는 스택에 들어감
                        break;
                }
            }
        }

        return postfix;
    }
}