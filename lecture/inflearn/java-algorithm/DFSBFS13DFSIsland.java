import java.util.Scanner;

/*
N*N 개의 섬나라 아일랜드 - 상하좌우 대각선으로 연결되어 있음. 1이 섬이고, 0은 바다.
몇 개의 섬이 있는지? - DFS

7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

5
 */
public class DFSBFS13DFSIsland {
    static int N, answer = 0;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        DFSBFS13DFSIsland T = new DFSBFS13DFSIsland();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        solution(arr);
        System.out.println(answer);
    }

    private static void solution(int[][] board) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    DFS(i, j, board);
                }
            }
        }
    }

    private static void DFS(int x, int y, int[][] board) {
        for(int i = 0; i < 8; i++) { // 상하좌우 대각선 8방향
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(nx, ny, board);
            }
        }
    }
}
