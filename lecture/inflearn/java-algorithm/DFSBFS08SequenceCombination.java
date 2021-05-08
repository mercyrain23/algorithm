import java.util.Scanner;

/*
수열 구하기 - 조합, 순열, 메모이제이션 

4 16

3 1 2 4
 */
public class DFSBFS08SequenceCombination {
    static int N, F;
    static int[] b, p, check;
    boolean flag = false;
    int[][] dy = new int[35][35];

    public static void main(String[] args) {
        DFSBFS08SequenceCombination T = new DFSBFS08SequenceCombination();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        F = sc.nextInt();
        b = new int[N];
        p = new int[N];
        check = new int[N+1]; // index : 1~N까지의 숫자

        for(int i = 0; i < N; i++) {
            b[i] = T.combi(N - 1, i);// 조합 - 3C0, 3C1, 3C2, 3C3 : 1 3 3 1
        }
        T.DFS(0, 0);

    }

    private void DFS(int L, int sum) {
        if(flag) {
            return;
        }
        if(L == N) {
            if(sum == F) {
                flag = true;
                for(int x: p) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        } else {
            for(int i = 1; i <= N; i++) { // 순열 만드는 숫자
                if(check[i] == 0) {
                    check[i] = 1;
                    p[L] = i;
                    DFS(L+1, sum + (p[L] * b[L]));
                    check[i] = 0;
                }
            }
        }
    }

    private int combi(int N, int R) {
        if(dy[N][R] > 0) return dy[N][R];
        if(N == R || R == 0) return 1;
        else return dy[N][R] = combi(N-1, R-1) + combi(N-1, R);
    }
}
