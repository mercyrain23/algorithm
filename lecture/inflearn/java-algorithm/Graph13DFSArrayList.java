import java.util.ArrayList;
import java.util.Scanner;

// 경로 탐색(DFS) - 방향 그래프, 인접 리스트
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
public class Graph13DFSArrayList {

    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check;

    public static void main(String[] args) {
        Graph13DFSArrayList T = new Graph13DFSArrayList();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        check = new int[n+1];
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        check[1] = 1; // 출발점
        T.DFS(1);
        System.out.println(answer);
    }

    private void DFS(int v) {
        if(v == n) answer++;
        else {
            for(int nv: graph.get(v)) {
                if(check[nv] == 0) {
                    check[nv] = 1;
                    DFS(nv);
                    check[nv] = 0;
                }
            }
        }
    }
}
