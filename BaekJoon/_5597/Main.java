package baekjoon._5597;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int MAX_NUM = 30;
        int arr[] = new int[MAX_NUM+1];

        int inputNumber;
        for(int i=0 ; i<MAX_NUM-2 ; i++){
            inputNumber = Integer.parseInt(br.readLine());
            arr[inputNumber] = 1;
        }
        for(int i=1 ; i<MAX_NUM+1 ; i++){
            if(arr[i] != 1){
                sb.append(i).append("\n");
            }
        }
        sb.deleteCharAt(sb.toString().length()-1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
