import java.util.Scanner;

public class TowPointersSlidingWindow03 {
    public static void main(String[] args) {
        TowPointersSlidingWindow03 T = new TowPointersSlidingWindow03();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr, K));
    }

    private int solution(int[] arr, int k) {
        int sum = arr[0] + arr[1] + arr[2];
        int answer = sum;
        for(int i = 3; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i-k];
            if(answer < sum) {
                answer = sum;
            }
        }
        return answer;
    }


}
