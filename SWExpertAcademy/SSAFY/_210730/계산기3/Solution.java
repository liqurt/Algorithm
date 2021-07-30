package _210730.dailyHW.계산기3;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
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
            if(isInteger(postfix[i])){
                stack[++top] = postfix[i];
            }else{
                int b = Integer.parseInt(stack[top]);
                stack[top--] = "";
                int a = Integer.parseInt(stack[top]);
                stack[top--] = "";
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
        return Integer.parseInt(stack[top--]);
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
            if (isInteger(token)) {
                postfix[j++] = token;
            } else {
                switch (token) {
                    case "(":
                        stack[++top] = token;
                        break;
                    case ")":
                        while (true) {
                            if (stack[top].equals("(")) {
                                stack[top] = null;
                                top--;
                                break;
                            } else {
                                postfix[j++] = stack[top];
                                stack[top] = null;
                                top--;
                            }
                        }
                        break;
                    case "+":
                        if (stack[top].equals("+") || stack[top].equals("*")) {
                            postfix[j++] = stack[top];
                            stack[top] = null;
                            top--;
                        }
                        stack[++top] = token;
                        break;
                    case "*":
                        if (stack[top].equals("*")) {
                            postfix[j++] = stack[top];
                            stack[top] = null;
                            top--;
                        }
                        stack[++top] = token;
                        break;
                }
            }
        }

        return postfix;
    }
}