package BOJ._15596;

public class Test {
    long sum(int[] a){
        long sumsum = 0;
        for (int i = 0; i < a.length; i++) {
            sumsum+=a[i];
        }
        return sumsum;
    }
}
