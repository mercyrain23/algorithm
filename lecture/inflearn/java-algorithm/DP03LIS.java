import java.util.Scanner;

/*
최대부분 증가수열(LIS)

8
5 3 7 8 6 2 9 4

4
 */
public class DP03LIS {
    static int[] dy;
    public static void main(String[] args) {
        DP03LIS T = new DP03LIS();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr));
    }

    private int solution(int[] arr) {
        int answer = 0;
        dy = new int[arr.length];
        dy[0] = 1;

        for(int i = 1; i < arr.length; i++) {
            int max = 0;
            for(int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }
//        for(int i: dy) {
//            System.out.println(i);
//        }
        return answer;
    }
}
