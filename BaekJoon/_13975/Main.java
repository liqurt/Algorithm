package _13975;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");

            // 작은 파일끼리 계속 합칠거임 -> 그럴때 쓰는 min 힙 트리 -> min 힙 트리는 우선 큐를 쓴다
            PriorityQueue<Long> pq = new PriorityQueue<>();
            while(st.hasMoreTokens()){
                String item = st.nextToken();
                pq.add(Long.parseLong(item)); // 다 민힙트리에 넣음
            }

            long cost = 0;
            long localCost;
            while(!pq.isEmpty()){
                long item1 = pq.poll(); // 민힙트리에서 하나 빼고
                if(pq.isEmpty()){ // 2개 빼고 1개 더하니까 언젠가는 민힙트리에 1개만 남게 될 것임(즉, 더이상 더할게 없음)
                    break;
                }else{
                    long item2 = pq.poll();// 하나 더 뺌
                    localCost = item1+item2; // 더해서
                    pq.add(localCost); // 다시 넣음
                    cost+=localCost; // localCost : 더하는데 쓴 비용, cost : 총 cost
                }
            }

            sb.append(cost);
            if(tc < t-1){
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

}
