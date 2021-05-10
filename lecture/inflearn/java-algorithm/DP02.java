import java.util.Scanner;

/*
돌다리 건너기 -> 돌의 개수 + 마지막 다리 건너는거까지
 */
public class DP02 {
    static int[] dy;
    public static void main(String[] args) {
        DP02 T = new DP02();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dy = new int[N+2];
        System.out.println(T.solution(N));
    }

    private int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <= n+1; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }
        return dy[n+1]; // 마지막에 건너는 거까지 +1
    }

}
