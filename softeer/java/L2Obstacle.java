import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
장애물 인식 프로그램
1은 장애물, 0은 도로

7
1110111
0110101
0110101
0000100
0110000
0111110
0110000

 */
public class L2Obstacle {

    static int N, count = 0;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        L2Obstacle T = new L2Obstacle();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            String str = sc.next();
            char[] tmp = str.toCharArray();
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(tmp[j-1]));
            }
        }

        solution();
        System.out.println(answer.size());
        Collections.sort(answer);
        for(Integer x : answer) {
            System.out.println(x);
        }
    }
    private static void solution() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(map[i][j] == 1) {
                    map[i][j] = 0;
                    count = 1;
                    DFS(i, j);
                    //System.out.print(count + " ");
                    answer.add(count);
                }
            }
        }
    }

    private static void DFS(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 1 && nx <= N && ny >= 1 && ny <= N && map[nx][ny] == 1) {
                map[nx][ny] = 0;
                count++;
                DFS(nx, ny);
            }
        }
    }
}
