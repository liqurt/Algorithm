// 내가 안 짰음
// (https://mungto.tistory.com/254)

package SSAFY._210906.수영장;

import java.io.*;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) throws IOException {
        final String inputFilePath = "./src/SSAFY/_210906/수영장/sample_input.txt";
        final File inputFile = new File(inputFilePath);

        // System.setIn(new FileInputStream(inputFilePath));
        // Scanner sc = new Scanner(System.in);

//         BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br2 = new BufferedReader(new FileReader(inputFile));

        int T = Integer.parseInt(br2.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {

            String[] temp = br2.readLine().split(" ");
            int[] ticket = new int[4];
            for(int i=0 ; i<temp.length; i++){
                ticket[i] = Integer.parseInt(temp[i]);
            }
            temp = br2.readLine().split(" ");
            int[] plan = new int[12];
            for(int i=0 ; i<temp.length; i++){
                plan[i] = Integer.parseInt(temp[i]);
            }

            int[] result = new int[13];
            for(int i=1 ; i<result.length; i++){
                int[] cost = {0,0,Integer.MAX_VALUE,Integer.MAX_VALUE};
                cost[0] = result[i-1] + plan[i-1] * ticket[0];
                cost[1] = result[i-1] + ticket[1];
                if(3<=i){
                    cost[2] = result[i-3] + ticket[2];
                }
                if(12<=i){
                    cost[3] = ticket[3];
                }
                result[i] = minInArr(cost);
            }

            String resultStr = "#"+test_case+" "+result[12];
            System.out.println(resultStr);
        }
    }

    private static int minInArr(int[] arr){
        int min=Integer.MAX_VALUE;
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
}


