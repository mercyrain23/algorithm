import java.util.Scanner;

/*
미로 탐색 - 1은 벽이고 0은 통로. 출발점에서 도착점까지 갈 수 있는 방법의 수

0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0

8
 */
public class DFSBFS10DFSMiro {
    // 12시, 3시, 6시, 9시 
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int answer = 0;

    public static void main(String[] args) {
        DFSBFS10DFSMiro T = new DFSBFS10DFSMiro();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        for(int i = 1; i <= 7; i++) {
            for(int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        board[1][1] = 1; // start
        T.DFS(1, 1);
        System.out.println(answer);
    }

    private void DFS(int x, int y) {
        if(x == 7 && y == 7) {
            answer++;
        } else {
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 1 && nx <=7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }
}
