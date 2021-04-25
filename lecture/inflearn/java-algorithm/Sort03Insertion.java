import java.util.Scanner;

public class Sort03Insertion {
    public static void main(String[] args) {
        Sort03Insertion T = new Sort03Insertion();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x: T.solution(N, arr)) System.out.print(x + " ");
    }

    private int[] solution(int n, int[] arr) {
        for(int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for(j = i-1; j >=0; j--) {
                if(arr[j] > tmp)
                    arr[j+1] = arr[j];
                else
                    break;
            }
            arr[j+1] = tmp;
        }
        return arr;
    }
}

