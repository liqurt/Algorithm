package baekjoon._4673;

public class Main {
    public static void main(String[] args){
        boolean[] selfNum = new boolean[10040];

        for(int n=1 ; n <= 10001 ; n++){
            int item = n;
            int sum = n;
            while (true){
                sum += item%10;
                item = item/10;
                if(item == 0) break;
            }
            selfNum[sum] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            if(!selfNum[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
