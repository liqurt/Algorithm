package SSAFY._210830;

import java.io.FileInputStream;
import java.util.Scanner;

/*
* 문제 :
* N개의 LED가 쫘라락 있는데
* i번을 누르면 i의 배수의 LED들이 조작된다.
* 원하는 LED패턴을 입력받을 거고, 모든 LED들이 꺼진 상태에서 시작해 원하는 LED패턴에
* 도달하는데 까지 최소 몇번의 스위치를 눌러야 할까?
*
* 입력 :
* T
* N
* data
* ... (T회 반복)
* N
* data
* 접근 방식 1 : 모든 경우의 수를 조사함. N이 20이면 [20C20, 20C19, 20C18... 20C1]의 모든 조합을 생각함.
* 한계 : 존나 오래걸림 씨발
*
* 접근 방식 2 : '소수' 번째 LED는 오직 자신만이 눌려야 조작이 됨. 다른 스위치를 누른대도 변함 없음.
* 한계 : 소수를 다룰 코드도 따로 작성해야하고 여전히 존나 오래걸림 씨발 이딴걸 생각하고 와 씨발 나 천재네? 했던 내 자신이 병신같다. 결국 3시간이 가도록 13/50 pass
*
* 접근 방식 3 : Greedy 스타일 - 1번을 조작하려면, 오직 1번을 누르는 것으로만 가능함.. 그런 식으로 왼쪽부터 차근차근 입력값과 대조하며 눌러감.
* 한계 : 빡통인 내 대가리로 3시간 안에 생각할수 없음. 구현하는데 30분 걸림. 시발
* */
class Solution{
    static int toggleCount;
    public static void main(String[] args) throws Exception{
        final String filePath = "./src/SSAFY/_210830/input.txt";
        System.setIn(new FileInputStream(filePath));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            int[] arr = new int[N];
            int[] arr2 = new int[N];
            toggleCount = 0;
            for(int i=0 ; i<N ; i++){
                arr[i] = sc.nextInt();
                while(arr[i] != arr2[i]){
                    toggle(i, arr2);
                }
            }
            System.out.println("#"+tc+" "+toggleCount);
        }
    }
    private static void toggle(int n, int[] arr){
        toggleCount++;
        for(int i=0 ; i<arr.length ; i++){
            if((i+1)%(n+1) == 0){
                if(arr[i]==1) arr[i] = 0;
                else arr[i] = 1;
            }
        }
    }
}
