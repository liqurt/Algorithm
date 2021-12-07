package SWEA._13349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int y;
    int x;
    int category;
    int number;
    int[] cost;
    int numberOfWay;

    public int getCategory() {
        return category;
    }

    public int getNumber() {
        return number;
    }

    public Point(int _y, int _x, int _category){
        this.y = _y;
        this.x = _x;
        this.category = _category;
    }

    public Point(int _y, int _x, int _category, int _number){
        this.y = _y;
        this.x = _x;
        this.category = _category;
        this.number = _number;
    }
}

class Solution {

    static int L;
    static int answer;
    static ArrayList<Point> pointList;
    static Stack<Integer> stack;
    static boolean[] visited;
    static int goriCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            int[][] board = new int[M][N];
            int goriCount = 0;
            pointList = new ArrayList<>();
            for(int i=0 ; i<M ; i++){
                st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()){
                    int item = Integer.parseInt(st.nextToken());
                    int y = i;
                    int x = N-st.countTokens()-1;
                    board[y][x] = item;

                    if(item != 0){
                        Point point = new Point(y, x, item);
                        if(item == 1){
                            point.number = goriCount++;
                            point.category = 2;
                        }else if(item == 2){
                            point.category = 0;
                        }else if(item == 3){
                            point.category = 1;
                        }
                        pointList.add(point);
                    }
                }
            }
            pointList.sort(Comparator.comparing(Point::getCategory).thenComparing(Point::getNumber));
//            showPositionList(positionList);

            initCost(goriCount+2);
            answer = 100;
            visited = new boolean[goriCount+2];
            stack = new Stack<>();

            dfs(0);

//            showPointList(pointList);
            if(answer == 100)
                answer = -1;
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void initCost(int pointSize) {
        for (int i = 0; i < pointSize; i++) {
            pointList.get(i).cost = new int[pointSize];
        }

        Point start = null;
        Point end;
        int distance;
        for (int i = 0; i < pointSize; i++) {
            int k = 0;
            if(i != 1){
                start = pointList.get(i);
            }
            for (int j = 1; j < pointSize; j++) {
                if(i!=j){
                    end = pointList.get(j);
                    distance = Math.abs(start.y-end.y) + Math.abs(start.x-end.x);
                    if(distance <= L){
                        pointList.get(i).cost[j] = distance;
                        k++;
                    }
                }
            }
            pointList.get(i).numberOfWay = k;
        }
    }

    private static void dfs(int p) {
        visited[p] = true;
        stack.push(p);
        if(2 <= p)
            goriCount++;
        if(p == 1){
            if(goriCount < answer){
                answer = goriCount;
            }
        }
        else{
            int goIndex=0;
            int[] go = new int[pointList.get(p).numberOfWay];
            for (int i = 0; i < pointList.size(); i++) {
                if(0 < pointList.get(p).cost[i]){
                    go[goIndex++] = i;
                }
                if(goIndex == pointList.get(p).numberOfWay){
                    break;
                }
            }
            for (int j = 0; j < go.length; j++) {
                if(!visited[go[j]]){
                    dfs(go[j]);
                    visited[go[j]] = false;
                    stack.pop();
                    if(2 <= go[j]){
                        goriCount--;
                    }
                }
            }
        }
    }

    public static void showPointList(ArrayList<Point> al){
        for (Point point : al) {
            System.out.println(point.y + "," + point.x + " : " + point.category + " / " + point.number + " | " + Arrays.toString(point.cost) + "(" + point.numberOfWay + ")");
        }
    }

    public static void show2DArr(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}