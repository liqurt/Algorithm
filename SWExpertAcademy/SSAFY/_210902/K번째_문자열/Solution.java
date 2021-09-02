package SSAFY._210902.K번째_문자열;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        final String inputFilePath = "./src/SSAFY/_210902/K번째_문자열/input.txt";
        System.setIn(new FileInputStream(inputFilePath));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int C = 1; C <= T; C++) {
            int K = sc.nextInt();
            String str = sc.next();

            String result ="";
            result = kthSubString(K,str);

            System.out.printf("#%d %s\n",C,result);
        }
    }

    private static String kthSubString(int k, String str){
        //str +="$"; 없어도 큰 지장 없더라
        int[] suffixArray = new int[str.length()];
        for(int i=0 ; i<suffixArray.length ; i++){
            suffixArray[i] = i;
        }

        // suffixArray를 사전적 순서로 정렬
        for(int i=0 ; i<suffixArray.length ; i++){
            int target = i;
            for(int j=target ; j<suffixArray.length ; j++){
                String subStr1 = str.substring(suffixArray[target]);
                String subStr2 = str.substring(suffixArray[j]);
                if(0 < subStr1.compareTo(subStr2)){ // > subStr2 < subStr1
                    target = j;
                }
            }
            int temp = suffixArray[target];
            suffixArray[target] = suffixArray[i];
            suffixArray[i] = temp;
        }

        // LCP 생성
        int[] LCP = new int[suffixArray.length];
        for(int i=0 ; i<LCP.length; i++){
            if(i==0) LCP[i] = 0;
            else{
                String subStr1 = str.substring(suffixArray[i-1]);
                String subStr2 = str.substring(suffixArray[i]);
                for(int j =0 ; j<subStr2.length() ; j++){
                    if(j == subStr1.length()) {
                        break;
                    }
                    if(subStr2.charAt(j) == subStr1.charAt(j)){
                        LCP[i]++;
                    }
                    else {
                        break;
                    }
                }
            }
        }

        // 결과
        int count=0;
        for(int i=0 ; i<suffixArray.length ; i++){
            String subStr1 = str.substring(suffixArray[i]);
            for(int j=1 ; j<subStr1.length()+1 ;j++){
                if(LCP[i]<j){
                    String subStr2 = subStr1.substring(0,j);
                    count++;
                    if(count == k){
                        return subStr2;
                    }
                }
            }
        }

        return "none";
    }
}


