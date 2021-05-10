import java.util.Arrays;
import java.util.Scanner;

/*
성적 평균

5 3
10 50 20 60 100
1 3
3 4
1 5

26.67
45.00
50.00


1 1
10
1 1


 */
public class L3GradeAverage {
    public static void main(String[] args) {
        L3GradeAverage T = new L3GradeAverage();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] num = new int[N+1];
        int[] sum = new int[N+1];
        int[][] arr = new int[K][2];
        for(int i = 1; i <= N; i++) {
            num[i] = sc.nextInt();
            sum[i] = sum[i-1] + num[i];
        }

        //System.out.println(Arrays.toString(sum));
        for(int i = 0; i < K; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            arr[i][0] = s;
            arr[i][1] = e;
        }

        for(int i = 0; i < K; i++) {
            int s = arr[i][0];
            int e = arr[i][1];

            int score = sum[e] - sum[s-1];
            int cnt = e - s + 1;
            float avg = (float) ((1.00 * score / cnt));
            System.out.println(String.format("%.2f", avg) + " " + avg);

//            avg[i] = String.format("%.2f", 1.0 * (sum[K2] - sum[K1-1]) / (K2-K1+1) );
        }
    }
}
