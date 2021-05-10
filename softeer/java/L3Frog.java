import java.util.Scanner;

/*
우물 안 개구리

5 3
1 2 3 4 5
1 3
2 4
2 5

=> 3

5 3
7 5 7 7 1
1 2
2 3
3 4

=> 2

5 1
7 5 7 7 1
1 2
 */
public class L3Frog {
    public static void main(String[] args) {
        L3Frog T = new L3Frog();

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] num = new int[N+1];
        int[] check = new int[N+1];

        for(int i = 1; i <= N; i++) {
            num[i] = sc.nextInt();
            check[i] = 0;
        }

        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 졌으면 1
            if(num[a] > num[b] && num[b] != 0) {
                check[b] = 1;
            }
            if(num[a] < num[b] && num[a] != 0) {
                check[a] = 1;
            }
            if(num[a] == num[b]){
                check[a] = 1;
                check[b] = 1;
            }
        }
        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(check[i] != 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
