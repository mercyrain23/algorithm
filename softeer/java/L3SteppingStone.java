import java.util.Scanner;

/*
징검다리 - DP? LIS

5
3 2 1 4 5

=> 3
 */
public class L3SteppingStone {
    public static void main(String[] args) {
        L3SteppingStone T = new L3SteppingStone();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dp = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }

        int answer = 0;

        for(int i = 0; i < N; i++) {
            int max = 0;
            for(int j = i-1; j >= 0; j--) {
                if(arr[i] > arr[j]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
