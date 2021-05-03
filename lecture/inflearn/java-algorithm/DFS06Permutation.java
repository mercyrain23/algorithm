import java.util.Arrays;
import java.util.Scanner;

/*
순열 구하기(중복 허용하지 않음)
오름차순으로 출력

3 2
3 6 9

3 6
3 9
6 3
6 9
9 3
9 6

 */
public class DFS06Permutation {
    static int N, M;
    static int[] check, pm;

    public static void main(String[] args) {
        DFS06Permutation T = new DFS06Permutation();

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        check = new int[N];
        pm = new int[M];

        Arrays.sort(arr);

         T.DFS(0, arr);
    }

    private void DFS(int L, int[] arr) {
        if(L == M) {
            for(int x: pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for(int i = 0; i < N; i++) {
                if(check[i] == 0) {
                    check[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1, arr);
                    check[i] = 0;
                }
            }
        }
    }
}
