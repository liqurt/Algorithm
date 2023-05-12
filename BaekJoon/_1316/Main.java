package baekjoon._1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if(word.length() == 1){
                count+=1;
            }else{
                int result = isGroup(word);
                count+=result;
            }
        }
        System.out.println(count);
    }

    private static int isGroup(String word) {
        int result = 1;
        char[] lineArr = word.toCharArray();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);

        for (int i = 0; i < lineArr.length; i++) {
            char item = lineArr[i];
            if(alphabet[item-97] < 0){
                alphabet[item-97] = i;
            }else if(0 <= alphabet[item-97]){
                char prevItem = lineArr[i-1];
                if(prevItem == item){
                    if(alphabet[item-97] == i-1){
                        alphabet[item-97] = i;
                    }
                    else{
                        result = 0;
                        break;
                    }
                }else{
                    result = 0;
                    break;
                }
            }
        }

        return result;
    }
}
