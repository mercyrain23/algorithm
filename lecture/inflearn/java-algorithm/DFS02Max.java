import java.util.Scanner;
/*
바둑이 승차 - 부분 집합
259 5
81
58
42
33
61

242
 */
public class DFS02Max {
    static int N, C, answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        DFS02Max T = new DFS02Max();

        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int L = 0;
        T.DFS(L, sum, arr);
        System.out.println(answer);
    }

    private void DFS(int L, int sum, int[] arr) {
        if(sum > C) return;
        if(L == N) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L+1, sum + arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }


}
