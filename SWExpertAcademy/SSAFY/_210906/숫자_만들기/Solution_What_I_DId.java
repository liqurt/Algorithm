package SSAFY._210906.숫자_만들기;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class Solution_What_I_DId {

    static int dupCount;
    static int swapCount;
    static ArrayList<String> operatorCombo;
    static int max;
    static int min;

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        final String inputFilePath = "./src/SSAFY/_210906/숫자_만들기/sample_input.txt";
        final File inputFile = new File(inputFilePath);
        final String[] operatorList = {"+","-","*","/"};
        // System.setIn(new FileInputStream(inputFilePath));
        // Scanner sc = new Scanner(System.in);

        // BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br2 = new BufferedReader(new FileReader(inputFile));

        int T = Integer.parseInt(br2.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            operatorCombo = new ArrayList<>();
            swapCount =0;
            dupCount=0;

            min=Integer.MAX_VALUE;
            max=Integer.MIN_VALUE;

            int N = Integer.parseInt(br2.readLine());

            String[] temp = br2.readLine().split(" ");
            int[] temp2 = new int[4];
            for(int i=0 ; i<4 ; i++){
                temp2[i] = Integer.parseInt(temp[i]);
            }
            String[] operator = new String[N-1];
            for(int i=0,j=0 ; j<operator.length ; i++){
                while(0 < temp2[i]){
                    operator[j] = operatorList[i];
                    j++;
                    temp2[i]--;
                }
            }

            int[] numbers = new int[N];
            temp = br2.readLine().split(" ");
            for(int i=0 ; i<N ; i++){
                numbers[i] = Integer.parseInt(temp[i]);
            }

            System.out.println(Arrays.toString(operator));
            System.out.println(Arrays.toString(numbers));

            if(1 <=test_case && test_case <= 10){
                long start = System.currentTimeMillis();
                permutation(operator,0, operator.length, operator.length);
                long end = System.currentTimeMillis();
                System.out.printf("%d tc\n%d ms\nswapCount %d\ndupCount %d\n\n",test_case,end-start,swapCount,dupCount);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("%d ms(all)\n",endTime-startTime);
    }

    // 순열 구하기
    // 사용 예시: permutation(arr, 0, n, 4);
    private static void permutation(String[] arr, int depth, int n, int r) throws IOException {
        if (depth == r) {
            String arr2 = Arrays.toString(arr);
            if(!operatorCombo.contains(arr2)){
                operatorCombo.add(arr2);

                //System.out.println(arr2);
            }else{
                dupCount++;
            }
            return;
            // 1. 중복 체크
            // 1-1. 중복 True = do nothing
            // 1-2. ArrayList에 넣음 -> 계산 -> min max 판별
        }

        for (int i = depth; i < n; i++) {
            // swap 하기전에, swap대상이 같은거면 하나마나임.
            if(!arr[depth].equals(arr[i]))
                swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            if(!arr[depth].equals(arr[i]))
                swap(arr, depth, i);
        }
    }

    private static void swap(String[] arr, int depth, int i) {
        swapCount++;
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    // 배열 출력
    private static void print(String[] arr) throws IOException {
        BufferedWriter br1 = new BufferedWriter(new OutputStreamWriter(System.out));
        String str="";
        for (int i = 0; i < arr.length; i++)
            str+=arr[i] + " ";
        str+="\n";
        br1.write(str);
        br1.flush();
    }

}


