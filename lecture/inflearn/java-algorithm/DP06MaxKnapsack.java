import java.util.Scanner;

/*
최대점수 구하기(냅색 알고리즘)
제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록

5 20
10 5
25 12
15 8
6 3
7 4

41
 */
public class DP06MaxKnapsack {

    public static void main(String[] args) {
        DP06MaxKnapsack T = new DP06MaxKnapsack();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] dy = new int[M+1];
        for(int i = 0; i < N; i++) {
            int ps = sc.nextInt();
            int pt = sc.nextInt();

            for(int j = M; j >= pt; j--) {
                dy[j] = Math.max(dy[j], dy[j-pt] + ps);
            }
        }
        System.out.println(dy[M]);
    }
}
