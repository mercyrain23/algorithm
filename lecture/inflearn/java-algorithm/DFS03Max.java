import java.util.Scanner;

/*
최대점수 구하기(DFS) - 부분집합

5 20
10 5
25 12
15 8
6 3
7 4

41
 */
public class DFS03Max {
    static int answer = Integer.MIN_VALUE, N, M;

    public static void main(String[] args) {
        DFS03Max T = new DFS03Max();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int[] score = new int[N];
        int[] times = new int[N];
        for(int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
            times[i] = sc.nextInt();
        }

        T.DFS(0, 0, 0, score, times);
        System.out.println(answer);
    }

    private void DFS(int L, int sum, int time, int[] ps, int[] pt) {
        if(time > M) return;

        if(L == N) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L+1, sum + ps[L], pt[L] + time, ps, pt);
            DFS(L+1, sum, time, ps, pt);
        }
    }
}
