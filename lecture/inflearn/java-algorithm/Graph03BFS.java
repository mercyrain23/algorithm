import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 그래프 최단 거리(BFS), 배열
/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

2:3
3:1
4:1
5:2
6:2

 */
public class Graph03BFS {

    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check, dis;

    public static void main(String[] args) {
        Graph03BFS T = new Graph03BFS();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점
        m = sc.nextInt(); // 간선
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        check = new int[n+1];
        dis = new int[n+1];
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1);
        for(int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }

    private void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        check[v] = 1;
        dis[v] = 0;
        queue.offer(v);
        while(!queue.isEmpty()) {
            int cv = queue.poll();
            for(int nv: graph.get(cv)) {
                if(check[nv] == 0) {
                    check[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }
}
