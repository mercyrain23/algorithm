import java.util.Arrays;
import java.util.Scanner;

public class Sort08BinarySearch {
    public static void main(String[] args) {
        Sort08BinarySearch T = new Sort08BinarySearch();

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
        Arrays.sort(arr);
        int lt = 0;
        int rt = arr.length - 1;
        while(lt <= rt) {
            int mid = (lt+rt) / 2;
            if(arr[mid] == m) {
                answer = mid + 1;
                break;
            } else if(arr[mid] > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }
}
