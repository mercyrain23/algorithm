import java.util.Scanner;
/*
계단 오르기
 */
public class DP01 {
    static int[] dy;
    public static void main(String[] args) {
        DP01 T = new DP01();
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dy = new int[N+1];
        System.out.println(T.solution(N));
    }

    private int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <= n; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }
        return dy[n];
    }
}
