import java.util.Arrays;
import java.util.Scanner;

/*
동전교환(냅색 알고리즘) - 가장 적은 수의 동전으로 교환해주려면?

3
1 2 5
15

3
 */
public class DP05CoinKnapsack {
    static int N, M;
    static int[] dy;
    public static void main(String[] args) {
        DP05CoinKnapsack T = new DP05CoinKnapsack();

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        M = sc.nextInt();

        dy = new int[M+1];
        System.out.println(T.solution(arr));
    }

    private int solution(int[] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for(int i = 0; i < N; i++) {
            for(int j = coin[i]; j <= M; j++) {
                dy[j] = Math.min(dy[j], dy[j-coin[i]] + 1);
            }
        }

        return dy[M];
    }
}
