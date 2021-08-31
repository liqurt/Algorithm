package SSAFY._210831;

import java.util.Arrays;

public class 순열 {
    public static void main(String[] args) {
        int n = 3;
        int r = 3;
        int[] arr = {0,1,2};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];
        long start, end;

        start = System.currentTimeMillis();
        perm(arr, output, visited, 0, n, r);
        end = System.currentTimeMillis();
        System.out.println(end-start+"ms");

        start = System.currentTimeMillis();
        permutation(arr, 0, n, r);
        end = System.currentTimeMillis();
        System.out.println(end-start+"ms");

    }

    // 사전순으로 순열 구하기
    // 사용 예시: perm(arr, output, visited, 0, n, 3);
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    // 순열 구하기
    // 사용 예시: permutation(arr, 0, n, 4);
    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    // 배열 출력
    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
