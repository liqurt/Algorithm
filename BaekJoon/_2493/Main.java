package _2493;
// BOJ2493 탑

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Stack<int[]> stack = new Stack<>();
        for(int i = 1; i <= n; i++) {
            int towerHeight = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) { // 후보군 살펴봄
                if(stack.peek()[1] >= towerHeight) { // 지금 높이보다 스택게 크면
                    System.out.print(stack.peek()[0] + " "); // 스택에 있는 타워의 인덱스 출력
                    break;
                }
                stack.pop(); // 다음 후보로
            }
            if(stack.isEmpty()) { // 스택이 비었다 = 내 신호를 받을 타워가 없음
                System.out.print("0 ");
            }
            stack.push(new int[] {i, towerHeight}); // 잠재적으로 신호를 받을수 있는 타워가 될수도 있음.
        }
    }
}