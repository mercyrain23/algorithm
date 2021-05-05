import java.util.Scanner;

/*
조합수 (메모이제이션)

5 3

10

 */
public class DBFS07DFSCombiMemoization {
    int[][] memo = new int[35][35]; // 메모이제이션

    public static void main(String[] args) {
        DBFS07DFSCombiMemoization T = new DBFS07DFSCombiMemoization();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int R = sc.nextInt();

        System.out.println(T.DFS(N, R));
    }

    private int DFS(int n, int r) {
        if(memo[n][r] > 0) return memo[n][r];
        if(n == r || r == 0) return 1;
        else return memo[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r); // 조합 구하는 공식
    }
}
