package SWEA._1860.진기의_최고급_붕어빵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    // Scanner 대신 BufferedReader를 사용하는게 알고리즘에서 시간 절약의 70%를 차지한다!!
    public static void main(String[] args) throws IOException {
        my();
    }

    private static void my() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine()); // valueOf 보다 parseInt가 더 절약이 된다!

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); //delemeter를 입력해주면 조금 더 효율적임!
            int n = Integer.parseInt(st.nextToken()); // 사람 수
            int m = Integer.parseInt(st.nextToken()); // 붕어빵 만드는데 걸리는 시간
            int k = Integer.parseInt(st.nextToken()); // 붕어빵 갯수

            int[] arr = new int[11112];
            int sumK = 0;
            for (int i = 0; i < arr.length; i++) {
                if(i<m){
                    arr[i] = 0;
                }
                else if (i % m == 0) {
                    sumK += k;
                    arr[i] = sumK;
                } else {
                    if (arr[i - 1] != 0) {
                        arr[i] = arr[i - 1];
                    }
                }
            }
// 0 0 1 1 2
            int nowBread = 0;
            int minusCount = 0;
            boolean flag = true;

            String[] str = br.readLine().split(" ");
            int[] arrr = new int[str.length];
            for(int i=0 ; i<arrr.length ; i++){
                arrr[i] = Integer.parseInt(str[i]);
            }
            Arrays.sort(arrr);

            //StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i=0 ; i<n ; i++){
//                int temp = Integer.parseInt(st2.nextToken());
                int temp = arrr[i];
                minusCount++;
                nowBread = arr[temp] - minusCount;
                if(nowBread<0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append("#").append(testCase).append(" Possible").append("\n");
            }else{
                sb.append("#").append(testCase).append(" Impossible").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void his() throws IOException{
        /**
         *  수학
         *  1번째 사람이 도착한 시간에 붕어빵이 1개 이상 있어야함!
         *  2번째 사람이 도착한 시간에 붕어빵이 2개 이상 있어야함!
         *  ...
         *  i번째 사람이 도착한 시간에 붕어빵이 i개 이상 있어야함!
         *
         *  위 조건들 중 1가지라도 만족하지 못했다면 "Impossible"
         *  위 조건들을 모두 만족했다면 "Possible"
         *
         *  ---
         *
         *  i번째 사람이 도착한 시간에 몇 단위시간이 걸리는가? =  도착한 사람의 시간(=time[i]) / M
         *  i번째 사람이 도착한 시간에 붕어빵을 총 몇개 만들었는가? = (time[i]) / M * K
         *  판단조건 : i <= (time[i] / M) * K
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc =1 ; tc<t ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int[] time = new int[n+1]; //index 0을 쓰지 않겠다
            for(int i= 1; i<n ; i++){
                time[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(time); // 정렬 : 도착 순서가 뒤죽박죽이라 빨리 도착한 순서대로 오름차순 정렬

            String check = "Possible";
            for (int i=1 ; i<= n ; i++){
                if(i<= time[i]/m*k){
                    check = "Impossible";
                    break;
                }
            }

            sb.append("#").append(tc).append(" ").append(check).append("\n");
        }
        System.out.println(sb);
    }
}

