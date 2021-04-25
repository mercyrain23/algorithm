import java.util.Scanner;

public class Sort04LRU {
    public static void main(String[] args) {
        Sort04LRU T = new Sort04LRU();

        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x: T.solution(S, N, arr)) System.out.print(x + " ");
    }

    private int[] solution(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for(int x: arr) {
            int pos = -1;
            for(int i = 0; i < size; i++) {
                if(x == cache[i]) {
                    pos = i;
                }
            }
            if(pos == -1) {
                for(int i = size-1; i >= 1; i--) {
                    cache[i] = cache[i-1];
                }
            } else {
                for(int i = pos; i >= 1; i--) {
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }
}
