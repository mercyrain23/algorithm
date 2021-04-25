import java.util.Scanner;

public class Sort02Bubble {
    public static void main(String[] args) {
        Sort02Bubble T = new Sort02Bubble();

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
            for(int j = 0; j < n-i-1; j++) {
                 if(arr[j] > arr[j+1]) {
                     int tmp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = tmp;
                 }
            }

        }
        return arr;
    }
}
