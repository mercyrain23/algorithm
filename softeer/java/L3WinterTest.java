import java.util.Scanner;

/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 1 1 0 0 0 0
0 0 0 1 1 0 1 1 0
0 0 1 1 1 1 1 1 0
0 0 1 1 1 1 1 0 0
0 0 1 1 0 1 1 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0


8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0

=> 4
 */
public class L3WinterTest {
    static int N, M, answer = 0;
    static int[][] map, visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        L3WinterTest T = new L3WinterTest();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N+1][M+1];
        visited = new int[N+1][M+1];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                visited[i][j] = 0;
            }
        }

//        printMap(map);
//        printMap(visited);
        while(!check()) {
            visited = new int[N+1][M+1];

            DFS(0, 0);

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && visited[i][j] >= 2) map[i][j] = 0;
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
    private static void DFS(int x, int y) {
        visited[x][y] = 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!inRange(nx, ny)) continue;

            if(map[nx][ny] == 0 && visited[nx][ny] == 0) {
                DFS(nx, ny);
            } else {
                visited[nx][ny]++;
            }
        }
    }
    private static boolean inRange(int x, int y) {
        return (x >= 0 && x <= N && y >= 0 && y <= M);
    }
    private static boolean check() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void printMap(int[][] arr) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
//                if(map[i][j] > 0 ){
//                    System.out.print(" ");
//                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
