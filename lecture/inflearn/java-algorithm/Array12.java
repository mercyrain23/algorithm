import java.util.Scanner;

/*
4 3
3 4 1 2
4 3 2 1
3 1 4 2
 */
public class Array12 {
    public static void main(String[] args) {
        Array12 T = new Array12();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[M][N];
        for(int i = 0; i < M; i++) { // 테스트
            for(int j = 0; j < N; j++) { // 학생 수
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(arr, N, M));
    }

    private int solution(int[][] arr, int n, int m) {
        int answer = 0;
        for(int i = 1; i <= n; i++) { // 학생
            for(int j = 1; j <= n; j++) { // 다른 학생과 비교
                int cnt = 0;
                for(int k = 0; k < m; k++) { // 각 테스트마다
                    int pi = 0, pj = 0;
                    for(int s = 0; s < n; s++) { // 등수
                        if(arr[k][s] == i) {
                            pi = s;
                        }
                        if(arr[k][s] == j) {
                            pj = s;
                        }
                    }
                    if(pi < pj) cnt++;
                }
                if(cnt == m) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
