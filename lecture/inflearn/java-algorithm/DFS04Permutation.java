import java.util.Scanner;

/*
중복순열
3 2

1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
3 3
 */
public class DFS04Permutation {
    static int N, M;
    static int[] pm;

    public static void main(String[] args) {
        DFS04Permutation T = new DFS04Permutation();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        pm = new int[M];
        T.DFS(0);
    }

    private void DFS(int L) {
        if(L == M) {
            for(int i: pm) System.out.print(i + " ");
            System.out.println();
        } else {
            for(int i = 1; i <= N; i++) {
                pm[L] = i;
                DFS(L + 1);
            }
        }
    }
}
