import java.util.Scanner;
/*
8 6
1 2 1 3 1 1 1 2
 */
public class TowPointersSlidingWindow04 {
    public static void main(String[] args) {
        TowPointersSlidingWindow04 T = new TowPointersSlidingWindow04();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr, M));
    }

    private int solution(int[] arr, int m) {
        int answer = 0;
        int sum = 0, lt = 0, rt = 0;
        while(rt < arr.length) {
            sum += arr[rt];
            if(sum == m) {
                answer++;
            }
            while(sum >= m) {
                sum -= arr[lt];
                lt++;
                if(sum == m) {
                    answer++;
                }
            }
            rt++;
        }
        return answer;
    }


}
