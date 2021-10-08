package SWEA._1926;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n+1];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = String.valueOf(i);
        }
        String[] tempArr;
        int count;
        String resultString = "";
        for(int i=1 ; i<arr.length; i++){
           tempArr =  arr[i].split("");
           count = 0;
           for(int j=0 ; j< tempArr.length ; j++){
               if(tempArr[j].equals("3") ||tempArr[j].equals("6") ||tempArr[j].equals("9") ){
                  count++;
               }
           }
           if(count==0){
               resultString += String.valueOf(i);
           }else{
               for(int k=0 ; k<count ; k++){
                   resultString += "-";
               }
           }
           resultString += " ";
        }
        System.out.println(resultString);
    }
}

/*
* 1. n을 입력 받음
* 2. StringArray를 만듬, 그 size는 n+1 임. n이 10이면 어레이인덱스는 0~10까지 있다.
* 3. StringArray에 인덱스 숫자를 String화 해서 집어넣음
* 4. for문을 사용해서 StringArray의 인덱스 1부터 어레이의 끝까지 반복
* 5. 인덱스 i의 값을 가져옴.
* 6. StringArray[i] 를 spilt("") 한다. 그걸 tempArr[]에 담음(2중 루프)
* 7. tempArr의 시작부터 끝까지 3,6,9가 나왔는지 조사한다. Count는 0으로 둔다.
* 8. 시작부터 끝까지 단 하나의 3,6,9도 나오지 않았다면(=Count가 계속 0인 경우) i를 resultString에 붙인다.
* 9. tempArr를 조사하던 중 3,6,9 가 나올때마다 Count를 1증가.
* 10. Count가 0보다 크면, Count숫자 만큼 '-' 를 resultString에 붙인다.
* 11. resultString에 i나 '-'를 붙였다면, 띄어쓰기를 resultString에 붙인다.
* 12. i가 n보다 크면, 루프를 멈춘다.
* 13. resultString을 출력한다.
* */