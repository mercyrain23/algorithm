import java.util.Arrays;
import java.util.Scanner;

public class Sort09Decision {
    public static void main(String[] args) {
        Sort09Decision T = new Sort09Decision();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr, N, M));
    }

    private int solution(int[] arr, int n, int m) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    private int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;
        for(int x: arr) {
            if( (sum+x) > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }
}
