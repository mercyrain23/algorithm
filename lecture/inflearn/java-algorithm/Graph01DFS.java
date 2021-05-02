import java.util.Scanner;

// 경로 탐색(DFS) - 방향 그래프, 인접 행렬, 상태 트리
/*
1번에서 N번까지 경로 가짓수
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5

6
 */
public class Graph01DFS {

    static int n, m, answer = 0;
    static int[][] graph;
    static int[] check;

    public static void main(String[] args) {
        Graph01DFS T = new Graph01DFS();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n+1][n+1];
        check = new int[n+1];

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        check[1] = 1; // 출발점
        T.DFS(1);
        System.out.println(answer);
    }

    private void DFS(int v) {
        if(v == n) answer++;
        else {
            for(int i = 1; i <= n; i++) {
                if(graph[v][i] == 1 && check[i] == 0) { //방문하지 않은 노드 중 갈 수 있는 노드
                        check[i] = 1;
                        DFS(i);
                        check[i] = 0; // 재귀에서 back 하면 다시 체크를 풀어줌
                }
            }
        }
    }
}
