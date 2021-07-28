package _210728.dailyHW.String;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    private static final int T = 10;

    public static void main(String args[]) throws Exception
    {
        long start = System.currentTimeMillis();
        System.setIn(new FileInputStream("./src/_210728/dailyHW/String/test_input.txt"));
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt(); // test_case
            String target = sc.next();
            String str = sc.next();
            //int matchedCount = KMPPatternMatching(str,target);
            int matchedCount = BruteForcePatternMatching(str,target);
            System.out.println("#"+test_case+" "+matchedCount);
        }
        long end = System.currentTimeMillis();
        System.out.println("소요 시간(ms) : "+(end-start));
    }

    public static int BruteForcePatternMatching(String str, String target){
        int count = 0;
        for(int i=0 ; i<=str.length()-target.length() ; i++){
            String substr = str.substring(i,i+target.length());
            if(substr.equals(target)){
                count++;
            }
        }
        return count;
    }

    public static int KMPPatternMatching(String str, String target){

        //KMP를 쓰기 위해 pi[] 먼저 구함
        int[] pi = new int[target.length()];
        for(int i = 0 ; i<target.length() ; i++){
            if(i == 0){
                pi[0] = 0;
            }
            else{
                String N = target.substring(0,i+1);
                for(int j=0 ; j<i ; j++){
                    String head = N.substring(0,j+1);
                    String tail = N.substring(N.length()-j-1);
                    if(head.equals(tail)){
                        pi[i] = head.length();
                    }
                }
            }
        }

        //PatternMatching
        int count = 0;
        for(int i=0,kmp=0 ; i<=str.length()-target.length() ; i = i+kmp+1){
            String substr = str.substring(i,i+target.length());
            if(substr.equals(target)){
                count++;
            }else{
                for (int j = 0 ; j<target.length() ; j++){
                    if(substr.charAt(j) != target.charAt(j)){
                        kmp = pi[j];
                        break;
                    }
                }
            }
        }
        return count;
    }
}
