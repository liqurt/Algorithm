package _210805.dailyHW.균형점;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        final String filePath = "./src/_210805/dailyHW/균형점/input.txt";
        System.setIn(new FileInputStream(filePath));
        Scanner sc = new Scanner(System.in);

        final int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            final int N = sc.nextInt();
            double[][] m = new double[N][2]; // 좌표, 질량
            for(int i = 0 ; i<N ; i++)
                m[i][0] = sc.nextInt();
            for(int i = 0 ; i<N ; i++)
                m[i][1] = sc.nextInt();

            if(N == 2){
                double a = m[0][1]-m[1][1];
                double b = 2*m[0][0]*m[1][1]-2*m[0][1]*m[1][0];
                double c = m[0][1]*m[1][0]*m[1][0]-m[1][1]*m[0][0]*m[0][0];
                System.out.printf("#%d %.10f\n",test_case,Keun_Ui_Kong_Sik(a,b,c,m[0][0],m[1][0]));
            }else{

            }

        }
    }

    private static double Keun_Ui_Kong_Sik(double a, double b, double c,double leftX,double rightX){
        if(a == 0){
            if(b != 0){
               return c/-b;
            }
        }
        double mid = b*b - 4 * a * c;
        if(mid < 0)
            return -1;
        double midSqrt = Math.sqrt(mid);
        double r1 = -b+(midSqrt);
        double r2 = -b-(midSqrt);
        double result1 = (r1) / (2*a);
        double result2 = (r2) / (2*a);
        if((leftX<result1) && (result1<rightX)){
            return result1;
        }else{
            return result2;
        }
    }
}