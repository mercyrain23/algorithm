import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
동전 교환 - 거슬러 줄 동전의 최소 개수 => DFS, 상태 트리

3
1 2 5
15

3
 */
public class DFS05 {
    static int answer = Integer.MAX_VALUE, N, M;

    public static void main(String[] args) {
        DFS05 T = new DFS05();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        M = sc.nextInt();

        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 - 큰 값부터 적용이 되도록

        T.DFS(0, 0, arr);
        System.out.println(answer);
    }

    private void DFS(int L, int sum, Integer[] arr) {
        if(sum > M) return;
        if(L >= answer) return;

        if(sum == M) {
            answer = Math.min(answer, L);
        } else {
            for(int i = 0; i < N; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }
}
