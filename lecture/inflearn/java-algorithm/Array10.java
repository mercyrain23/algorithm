import java.util.Scanner;

/*
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2
 */
public class Array10 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Array10 T = new Array10();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(arr, N));
    }

    private int solution(int[][] arr, int n) {
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                boolean flag = true;
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if((nx >= 0 && nx < n && ny >= 0 && ny < n) && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                       break;
                    }
                }
                if(flag)
                    answer++;
            }
        }
        return answer;
    }
}
