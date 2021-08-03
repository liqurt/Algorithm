package _210803.dailyHW.사칙연산_유효성_검사;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static String[] data;
    static int N;

    public static void main(String[] args) throws Exception
    {
        System.setIn(new FileInputStream("./src/_210803/dailyHW/사칙연산_유효성_검사/input.txt"));
        Scanner sc = new Scanner(System.in);
        final int T = 10;

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(sc.nextLine());
            data = new String[N + 1];
            for(int i=0 ; i<N ; i++){
                String[] temp = sc.nextLine().split(" ");
                if(isInteger(temp[1])){
                    data[Integer.parseInt(temp[0])] = "1";
                }else{
                    data[Integer.parseInt(temp[0])] = "+";
                }
            }
            int oneCount = 0;
            int plusCount = 0;

            for(int i = 1 ; i<data.length ;i++){
                if(data[i].equals("1")) oneCount++;
                if(data[i].equals("+")) plusCount++;
            }

            // 이왜진???
            int result = (plusCount<oneCount)? 1 : 0;
            System.out.println("#"+test_case+" "+result);
        }
    }

    private static boolean isInteger(String s){
        try{
            int temp = Integer.parseInt(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

