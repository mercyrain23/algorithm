import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
토마토(BFS) - 토마토가 모두 익을때까지 최소 날짜. 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, -1은 토마토가 들어있지 않은
모든 익어있으면 0 익지 못하는 상황이면 -1

열(M) 행(N)
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1

4
 */
//class Point {
//    public int x, y;
//
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
public class DBFS12BFSTomato {
    static int M, N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        DBFS12BFSTomato T = new DBFS12BFSTomato();

        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        board = new int[N][M];
        dis = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) queue.offer(new Point(i, j)); // 익은 토마토들이 시작점. 시작점이 여러 개
            }
        }
        T.BFS();

        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    flag = false;
//                    break;
                }
//                System.out.print(dis[i][j] + " ");
            }
//            System.out.println();
        }

        if(flag) {
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    private void BFS() {
        while(!queue.isEmpty()) {
            Point tmp = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }
}
