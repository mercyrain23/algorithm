import java.util.Scanner;

public class TowPointersSlidingWindow06 {
    public static void main(String[] args) {
        TowPointersSlidingWindow06 T = new TowPointersSlidingWindow06();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr= new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(N, K, arr));
    }

    private int solution(int N, int K, int[] arr) {
        int answer = 0, cnt = 0, lt = 0;

        for(int rt = 0; rt < N; rt++) {
            if(arr[rt] == 0) {
                cnt++;
            }
            while(cnt > K) {
                if (arr[lt] == 0) {
                    cnt--;
                }
            }
            answer = Math.max(answer, rt-lt+1);
        }

        return answer;
    }
}
