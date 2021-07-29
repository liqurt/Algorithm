package _210729.dailyHW.거듭_제곱;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static final int T = 10;

    public static void main(String[] args) throws Exception
    {
        System.setIn(new FileInputStream("./src/_210729/dailyHW/거듭_제곱/input.txt"));
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sc.nextInt(); // test_case와 같음
            int under = sc.nextInt();
            int upper = sc.nextInt();
            System.out.println("#"+test_case+" "+power(under, upper));
        }
    }

    public static int power(int under, int upper){
        if(upper<2){
            return under;
        }else{
            return under *power(under,upper-1);
        }
    }

}