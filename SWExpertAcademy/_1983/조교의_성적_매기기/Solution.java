package SWEA._1983.조교의_성적_매기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {
    // Scanner 대신 BufferedReader를 사용하는게 알고리즘에서 시간 절약의 70%를 차지한다!!
    public static void main(String[] args) throws IOException {
//        my();
        his();
        plus();
    }

    private static void plus() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase < TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] m = new int[4][N];
            for(int k=1 ; k<=K ; k++){
                for(int i=0 ; i<4 ; i++){//행
                    for(int j=0 ; j<N ; j++){//열
                        if((i+j+1)%k == 0){ // 배수이면
                            m[i][j] = 1 - m[i][j]; // IDEA :  1이면 0, 0이면 1 만드는 간단한 방법!
                        }
                    }
                }
            }

            int sum = 0;
            for(int i=0 ; i<4 ; i++){//행
                for(int j=0 ; j<N ; j++){//열
                    sum += m[i][j]; // IDEA : 1의 갯수를 count하기보다, 그냥 다 더해보면 되겠구나!
                }
            }

            sb.append("#").append(testCase).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }

    private static void his() throws IOException {
        String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase < TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 10~100, 10의 배수
            int K = Integer.parseInt(st.nextToken()); // 1<=K<=N
            int[] total = new int[N]; // 총점 '만' 저장한다!
            for (int i = 0; i < total.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                total[i] = Integer.parseInt(st.nextToken()) * 35
                        + Integer.parseInt(st.nextToken()) * 45
                        + Integer.parseInt(st.nextToken()) * 20; // IDEA : 0.35 이따구로 곱하지 않는다!
            }
            int kVal = total[K - 1];
            int cnt = 0; // IDEA : 나 보다 큰 점수를 카운팅!
            for (int i = 0; i < total.length; i++) {
                if (kVal < total[i]) {
                    cnt++;
                }
            }
            sb.append("#").append(testCase).append(" ").append(grade[cnt/(N/10)]).append("\n");
        }
        System.out.println(sb);
        // comment : 위와 같은 똘똘한 방식으로 안 풀었다고 실망하지마랑~
    }

    private static void my() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final String[] hakjum = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};

        int t = Integer.parseInt(br.readLine()); // valueOf 보다 parseInt가 더 절약이 된다!

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " "); //delemeter를 입력해주면 조금 더 효율적임!
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            double[][] arr = new double[n + 1][6];// 중간, 기말, 과제, index, 총점, 학점
            // [보충] : 35 45 20 을 곱하면 사실 double 로 선언 안하고 int 로 선언 해도 된다!

            //입력 및 총점 계산
            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                double tempScore = 0;
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Double.parseDouble(st.nextToken());
                    // [보충] : 0.35를 곱하지말고 그냥 35 곱해도 된다.
                    // 어차피 절대적인 점수가 중요한게 아니니까!
                    if (j == 0) tempScore += arr[i][j] * 0.35;
                    else if (j == 1) tempScore += arr[i][j] * 0.45;
                    else tempScore += arr[i][j] * 0.20;
                }
                arr[i][3] = tempScore;
                arr[i][4] = i;
            }

            // 총점 기준으로 정렬
            Arrays.sort(arr, Comparator.comparingDouble(o1 -> o1[3]));

            // 학점 계산
            int loc = 0;
            int gubun = n / 10;
            for (int i = 1; i < n + 1; i++) {
                arr[i][5] = loc;
                if ((loc + 1) * gubun <= i) {
                    loc++;
                }
            }

            int tLoc = -1;
            for (int i = 0; i < arr.length; i++) {
                if ((double) k == arr[i][4]) {
                    tLoc = (int) arr[i][5];
                    break;
                }
            }

            sb.append("#").append(testCase).append(" ").append(hakjum[tLoc]).append("\n");

        }
        System.out.println(sb);
    }
}
