import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sort06 {
    public static void main(String[] args) {
        Sort06 T = new Sort06();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x: T.solution(N, arr)) System.out.print(x + " ");
    }
    private ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for(int i = 0; i < n; i++) {
            if(arr[i] != tmp[i]) {
                answer.add(i+1);
            }
        }
        return answer;
    }
}
