package _210804.dailyHW.단순_2진_암호코드;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static final String[] binaryPassword = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};

    public static void main(String[] args) throws Exception{
        final String inputFilePath = "./src/_210804/dailyHW/단순_2진_암호코드/input.txt";
        final int T;
        System.setIn(new FileInputStream(inputFilePath));
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt(); // 10

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt(), M = sc.nextInt();
            boolean flag =false;
            String text="";
            int k=-1;
            for(int i=0 ; i<N ;i++){
                String temp = sc.next();
                if(temp.contains("1") && !flag){
                    text = temp;
                    for(int j=text.length()-1 ; j>0 ; j--){
                        if(text.charAt(j) == '1'){
                            k=j;
                            flag = true;
                            break;
                        }
                    }
                }
            }
            text = text.substring(k-55,k+1);
            String[] dividedBy7bit = new String[8];
            int[] password = new int[8];
            for(int i=0 ; i<8 ;i++){
                dividedBy7bit[i] = text.substring((i*7),(i*7)+7);
                for(int j=0 ; j<10 ; j++){
                    if(binaryPassword[j].equals(dividedBy7bit[i])){
                        password[i] = j;
                    }
                }
            }

            int key = (password[0]+password[2]+password[4]+password[6])*3+(password[1]+password[3]+password[5]+password[7]);
            int result = 0;
            if(key%10 == 0){
                for(int i=0 ; i<8 ; i++){
                    result += password[i];
                }
            }

            System.out.println("#"+test_case+" "+result);
        }
    }
}