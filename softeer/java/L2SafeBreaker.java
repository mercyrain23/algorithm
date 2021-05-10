import java.util.Scanner;

/*
금고털이
greedy algorithm - 무게당 가치로 sorting 하고 가치가 높은 금속부터 넣는다 -> 무게당 가치 배열에 넣어서 스캔

100 2
90 1
70 2

=> 170

 */
public class L2SafeBreaker {
    public static void main(String[] args) {
        L2SafeBreaker T = new L2SafeBreaker();

        Scanner sc = new Scanner(System.in);

        int W = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[(int) Math.pow(10, 4) + 1];
        for(int i = 0; i < N; i++) {
            int weight = sc.nextInt();
            int price = sc.nextInt();
            arr[price] += weight;
        }

        int sum = 0;
        for(int i = (int) Math.pow(10, 4); i > 0; i--) {
            if(arr[i] != 0 && arr[i] <= W) {
                sum += i * arr[i];
                W -= arr[i];
            } else if ( arr[i] > W) {
                sum += i * W;
                break;
            }
        }
        System.out.println(sum);
    }
}
