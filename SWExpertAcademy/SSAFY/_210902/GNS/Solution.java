package SSAFY._210902.GNS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    static final String[] num1 = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

    public static void main(String[] args) throws FileNotFoundException {
        final String inputFilePath = "./src/SSAFY/_210902/GNS/GNS_test_input.txt";
        System.setIn(new FileInputStream(inputFilePath));
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            String[] temp = sc.nextLine().split(" ");
            int C = Integer.parseInt(temp[0].substring(1));
            int N = Integer.parseInt(temp[1]);
            String[] textNumbers = sc.nextLine().split(" ");

            int[] numbers = new int[N];
            for(int i=0 ; i<textNumbers.length; i++){
                String tNum = textNumbers[i];
                for(int j=0 ; j<num1.length; j++){
                    if(tNum.equals(num1[j])){
                        numbers[i] = j;
                        break;
                    }
                }
            }
            Arrays.sort(numbers);

            String[] resultArray = new String[N];
            String result="";
            for(int i=0 ; i< numbers.length ; i++){
                int me = numbers[i];
                for(int j=0 ; j<num1.length; j++){
                    if(me == j){
                        resultArray[i] = num1[j];
                        result += resultArray[i]+" ";
                        break;
                    }
                }
            }

            System.out.printf("#%d %s\n",test_case,result);
        }
    }
}


