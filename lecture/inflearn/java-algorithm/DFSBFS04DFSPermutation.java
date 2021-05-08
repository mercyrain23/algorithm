import java.util.Scanner;

/*
중복순열 - 숫자 3개 중에서 2개를 뽑아서 만들 수 있는 가짓수
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
public class DFSBFS04DFSPermutation {
    static int N, M;
    static int[] pm;

    public static void main(String[] args) {
        DFSBFS04DFSPermutation T = new DFSBFS04DFSPermutation();

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
