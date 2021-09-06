package SSAFY._210903.금속막대;

import java.io.*;
import java.util.Arrays;

class Solution {

    private static boolean[] visited;
    private static int max;
    
    public static void main(String[] args) throws IOException {
        final String inputFilePath = "./src/SSAFY/_210903/금속막대/input.txt";
        final File inputFile = new File(inputFilePath);

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[][] nasa = new int[n][2]; // 미항공우주국 아님
            for(int i=0 ; i<n ; i++){
                nasa[i][0] = Integer.parseInt(str[i*2]);
                nasa[i][1] = Integer.parseInt(str[i*2+1]);
            }

            for(int i=0 ; i<n ; i++){
                visited = new boolean[n];
            }
        }
    }


}