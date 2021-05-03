import java.util.Scanner;

/*
조합 구하기 - N번까지 있는 구슬 중에서 M개를 뽑는 방법의 수

4 2

1 2
1 3
1 4
2 3
2 4
3 4

 */
public class DFS09Combination {
    static int N, M;
    static int[] combi;

    public static void main(String[] args) {
        DFS09Combination T = new DFS09Combination();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        combi = new int[M];
        T.DFS(0, 1); // level, start
    }

    private void DFS(int L, int S) {
        if(L == M) {
            for(int x: combi) System.out.print(x + " ");
            System.out.println();
        } else {
            for(int i = S; i <= N; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
}
