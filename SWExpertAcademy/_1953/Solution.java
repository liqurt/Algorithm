package SWEA._1953;
// 1953. [모의 SW 역량테스트] 탈주범 검거
// 아아- 뿌듯-!
import java.io.*;
import java.util.Scanner;

class Solution {

    static int N,M,R,C,L,result;
    static int[][] underground;
    static boolean[][] visited;
    static final Point gubun = new Point(-1,-1);
    static int test_case;

    public static void main(String[] args) throws IOException {
        final String inputFilePath = "./src/SWEA/_1953/sample_input.txt";
        final File inputFile = new File(inputFilePath);

        System.setIn(new FileInputStream(inputFilePath));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            L = sc.nextInt();
            underground = new int[N][M];
            visited = new boolean[N][M];
            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<M ; j++){
                    underground[i][j] = sc.nextInt();
                    /*
                    * 1 : ┼
                    * 2 : │
                    * 3 : ─
                    * 4 : └
                    * 5 : ┌
                    * 6 : ┐
                    * 7 : ┘
                    * */
                }
            }

//            show2DArr(underground);
            Point start = new Point(R, C);
            if(L==1){
                result = 1;
            }else{
                BFS(start);
            }
            
            System.out.printf("#%d %d\n",test_case,result);
        }
    }

    private static void BFS(Point v) {
        Point[] Q = new Point[N*M];
        int f=-1, r=-1, countL=1;

        Q[++r] = v;
        result = 1;
        visited[v.y][v.x] = true;
        Q[++r] = gubun;

        while(true){
            v = Q[++f];
            if(f == r) break;
            if(v.equals(gubun)){
                Q[++r] = gubun;
//                System.out.print("--구분--\n");
                countL++;
                if(countL == L){
                    break;
                }
                continue;
            }
            Point[] neighbor = new Point[4]; //상하좌우
            fillNeighbor(v,neighbor);

            for (int i = 0; i < 4; i++) {
                if(neighbor[i].y == -1  || neighbor[i].x == -1){
                    continue;
                }
                if (!visited[neighbor[i].y][neighbor[i].x]) {
                    Q[++r] = neighbor[i];
                    result++;
                    visited[neighbor[i].y][neighbor[i].x] = true;
//                    System.out.printf("(%d,%d)\n",neighbor[i].y,neighbor[i].x);
                }
            }
        }
    }

    private static void fillNeighbor(Point me, Point[] neighbor) {
        for(int i=0 ; i<4 ; i++){
            neighbor[i] = new Point();
            switch (i){
                case 0 : neighbor[i] = fillNorth(me); break;
                case 1 : neighbor[i] = fillSouth(me); break;
                case 2 : neighbor[i] = fillWest(me); break;
                case 3 : neighbor[i] = fillEast(me); break;
            }
        }
    }

    private static boolean meValidNorth(Point me) {
        int mee = underground[me.y][me.x];
        return mee == 1 || mee == 2 || mee == 4 || mee == 7;
    }

    private static boolean meValidSouth(Point me) {
        int mee = underground[me.y][me.x];
        return mee == 1 || mee == 2 || mee == 5 || mee == 6;
    }

    private static boolean meValidWest(Point me) {
        int mee = underground[me.y][me.x];
        return mee == 1 || mee == 3 || mee == 6 || mee == 7;
    }

    private static boolean meValidEast(Point me) {
        int mee = underground[me.y][me.x];
        return mee == 1 || mee == 3 || mee == 4 || mee == 5;
    }

    private static Point fillNorth(Point me) {
        Point p = new Point();
        if(0 < me.y && meValidNorth(me)){
            int nei = underground[me.y-1][me.x];
            if((nei == 1) || (nei == 2) || (nei == 5) || (nei == 6)){
                p.y = (me.y)-1;
                p.x = me.x;
            }
        }
        return p;
    }

    private static Point fillSouth(Point me) {
        Point p = new Point();
        if(me.y < N-1 && meValidSouth(me)){
            int nei = underground[me.y+1][me.x];
            if((nei == 1) || (nei == 2) || (nei == 4) || (nei == 7)){
                p.y = (me.y)+1;
                p.x = me.x;
            }
        }
        return p;
    }

    private static Point fillWest(Point me) {
        Point p = new Point();
        if(0 < me.x && meValidWest(me)){
            int nei = underground[me.y][me.x-1];
            if((nei == 1) || (nei == 3) || (nei == 4) || (nei == 5)){
                p.y = me.y;
                p.x = me.x-1;
            }
        }
        return p;
    }

    private static Point fillEast(Point me) {
        Point p = new Point();
        if(me.x < M-1 && meValidEast(me)){
            int nei = underground[me.y][me.x+1];
            if((nei == 1) || (nei == 3) || (nei == 6) || (nei == 7)){
                p.y = me.y;
                p.x = me.x+1;
            }
        }
        return p;
    }

    private static class Point{
        int y;
        int x;

        public Point(int a, int b) {
            this.y = a;
            this.x = b;
        }

        public Point() {
            this.y = -1;
            this.x = -1;
        }
    }

    private static void show2DArr(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%2d ", anInt);
            }
            System.out.println();
        }
    }
}


