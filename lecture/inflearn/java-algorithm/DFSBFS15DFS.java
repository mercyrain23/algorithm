import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/*
피자 배달 거리 - DFS, 조합
0은 빈칸, 1은 집, 2는 피자집
도시의 피자배달거리가 최소가 되는 M 개의 피자집 선택해서, 최소 배달 거리 구하기

4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2

6
 */
//class Point{
//    public int x, y;
//
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
public class DFSBFS15DFS {
    static int N, M, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pz, hs; // 피자집, 집의 좌표

    public static void main(String[] args) {
        DFSBFS15DFS T = new DFSBFS15DFS();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        pz = new ArrayList<>();
        hs = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int tmp = sc.nextInt();
                if(tmp == 1) hs.add(new Point(i, j));
                else if(tmp == 2) pz.add(new Point(i, j));
            }
        }
        len = pz.size();
        combi = new int[M]; // lenCm 조합

        T.DFS(0, 0);
        System.out.println(answer);
    }

    private void DFS(int L, int s) {
        if(L == M) {
//            for(int x : combi) { // 전체 조합 출력
//                System.out.print(x + " ");
//            }
//            System.out.println();

            int sum = 0;
            for(Point h: hs) { // 집들
                int dis = Integer.MAX_VALUE;
                for(int i: combi) { // M개 선택된 피자집
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis; // 도시의 피자 배달 거리 합
            }
            answer = Math.min(answer, sum);
        } else {
            for(int i = s; i < len; i++) { // 0~5, 1~5, 2~5
                combi[L] = i;
                DFS(L+1, s+1);
            }
        }
    }
}
