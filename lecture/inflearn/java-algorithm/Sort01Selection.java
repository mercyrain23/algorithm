import java.util.Scanner;

public class Sort01Selection {
    public static void main(String[] args) {
        Sort01Selection T = new Sort01Selection();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x: T.solution(N, arr)) System.out.print(x + " ");
    }

    private int[] solution(int n, int[] arr) {
        for(int i = 0; i < n-1; i++) {
            int idx = i;
            for(int j = i+1; j < n; j++) {
                if(arr[j] < arr[idx]) idx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }

}
