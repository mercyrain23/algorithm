import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 송아지 찾기1(BFS) - 최단 거리
public class Tree04StateTreeBFS {

    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] check;
    Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Tree04StateTreeBFS T = new Tree04StateTreeBFS();

        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt(); // 5
        int E = sc.nextByte(); // 14
        System.out.println(T.BFS(S, E)); // 3
    }

    private int BFS(int s, int e) {
        check = new int[10000+1];
        check[s] = 1;

        int L = 0;
        queue.offer(s);

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int num = queue.poll();
//                if(num == e) return L;
                for(int j = 0; j < 3; j++) {
                    int nx = num + dis[j];
                    if (nx == e) return L+1;
                    if((nx >= 1 && nx <= 100000) && check[nx] == 0) {
                        check[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }
        return answer;
    }
}
