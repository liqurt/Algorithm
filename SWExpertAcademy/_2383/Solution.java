package SWEA._2383;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Position {
    int y;
    int x;
    int stairLength;

    public Position(int _y, int _x) {
        this.y = _y;
        this.x = _x;
    }
    public Position(int _y, int _x, int _stairLength) {
        this.y = _y;
        this.x = _x;
        this.stairLength = _stairLength;
    }
}

class Solution {

    static int[][] dist;
    static ArrayList<Position> sPos;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= t; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];
            ArrayList<Position> pPos = new ArrayList();
            sPos = new ArrayList();
            StringTokenizer st;
            for(int i=0 ; i<n ; i++){
                st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()){
                    int item = Integer.parseInt(st.nextToken());
                    board[i][n-st.countTokens()-1] = item;
                    if(item == 1){
                        Position person = new Position(i, n-st.countTokens()-1);
                        pPos.add(person);
                    }else if(item != 0){
                        Position stair = new Position(i, n-st.countTokens()-1, item);
                        sPos.add(stair);
                    }
                }
            }

            dist = new int[pPos.size()][2];
            for(int i=0 ; i<dist.length ; i++){
                dist[i][0] =
                        Math.abs(pPos.get(i).y - sPos.get(0).y) +
                        Math.abs(pPos.get(i).x - sPos.get(0).x);
                dist[i][1] =
                        Math.abs(pPos.get(i).y - sPos.get(1).y) +
                        Math.abs(pPos.get(i).x - sPos.get(1).x);
            }
//            show2DArr(dist);

            int answer = Integer.MAX_VALUE;
            int[] tempPeople = new int[pPos.size()];
            int[][] partOfSet = bitwiseCombination(tempPeople);
            for(int i=0 ; i< partOfSet.length; i++){
                int[] party = partOfSet[i];
                answer = Math.min(answer, move(party, pPos.size()));
            }

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int move(int[] party, int size) {
        ArrayList<Integer> arrival0 = new ArrayList();
        ArrayList<Integer> arrival1 = new ArrayList();

        int partyInt = partyToInt(party);
        for(int i=0 ; i<size ; i++){
            if((partyInt & (1<<i)) == 0){
                arrival0.add(dist[i][0]);
            }else{
                arrival1.add(dist[i][1]);
            }
        }

        return Math.max(downStairs(0,arrival0), downStairs(1,arrival1));
    }

    private static int downStairs(int entrance, ArrayList<Integer> arrivalTimes) {
        if(arrivalTimes.isEmpty()){
            return 0;
        }
        Collections.sort(arrivalTimes);
        int[] peopleInStairByTime = new int[200];

        int k =sPos.get(entrance).stairLength;

        for(int index = 0 ;index<arrivalTimes.size() ; index++){
            int i = arrivalTimes.get(index);
            int ii = i+1;
            while(3 <= peopleInStairByTime[ii]){
                ii++;
            }
            for(int j = ii ; j<ii+k ; j++){
                peopleInStairByTime[j]++;
            }
        }

        for (int i=199 ; 0 < i ; i--){
            if(peopleInStairByTime[i] != 0 ){
                return i+1;
            }
        }
        return -1;
    }

    private static int partyToInt(int[] party){
        int result = 0;
        for(int i=0 ; i<party.length ; i++){
            if(party[i] != 0){
                result += 1<<i * party[i];
            }
        }
        return result;
    }

    private static int[][] bitwiseCombination(int[] arr) {
        int[][] result = new int[1<<arr.length][arr.length];
        for (int i = 0; i < (1 << arr.length); i++) {
            int[] temp = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) > 0) {
                    temp[j] = 1; // arr[j]나 j 대신 1로 치환해도 될듯
                }else {
                    temp[j] = 0;
                }
            }
            result[i] = temp;
        }
        return result;
    }

    private static void show2DArr(int[][] arr){
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[i].length ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}