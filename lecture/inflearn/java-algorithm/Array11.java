import java.util.Scanner;
/*
5
2 3 1 7 3
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2
 */
public class Array11 {
    public static void main(String[] args) {
        Array11 T = new Array11();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N+1][6];
        for(int i = 1; i <= N; i++) { // 학생
            for(int j = 1; j <= 5; j++) { // 학년
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(arr, N));
    }

    private int solution(int[][] arr, int n) {
        int answer = 0, max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) { // 학생
            int cnt = 0;
            for(int j = 1; j <= n; j++) { // 학생
                for(int k = 1; k <= 5; k++) { // 학년
                    if(arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max) {
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }

}
