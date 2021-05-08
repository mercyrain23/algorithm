/*
N*N 개의 섬나라 아일랜드 - 상하좌우 대각선으로 연결되어 있음. 1이 섬이고, 0은 바다.
몇 개의 섬이 있는지? - BFS

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

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//class Point {
//    public int x, y;
//
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
public class DFSBFS14BFSIsland {
    static int N, answer = 0;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        DFSBFS14BFSIsland T = new DFSBFS14BFSIsland();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        T.solution(arr);
        System.out.println(answer);
    }

    private void solution(int[][] board) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    BFS(i, j, board);
                }
            }
        }
    }

    private void BFS(int x, int y, int[][] board) {
        queue.offer(new Point(x, y));

        while(!queue.isEmpty()) {
            Point tmp = queue.poll();
            for(int i = 0; i < 8; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }


}
