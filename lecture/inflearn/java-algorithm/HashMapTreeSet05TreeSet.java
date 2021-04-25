import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class HashMapTreeSet05TreeSet {

    public static void main(String[] args) {
        HashMapTreeSet05TreeSet T = new HashMapTreeSet05TreeSet();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++ ) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr, N, K));
    }

    private int solution(int[] arr, int n, int k) {
        int answer = -1;
//        TreeSet<Integer> tset = new TreeSet<>(); // 오름차순
        TreeSet<Integer> tset = new TreeSet<>(Collections.reverseOrder()); // 내림차순
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int l = j+1; l < n; l++) {
                    tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int idx = 0;
        for(int x: tset) {
            idx++;
            if(idx == k)
                return x;
            //System.out.print(x + " ");
        }

        return answer;
    }
}
