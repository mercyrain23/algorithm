import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TowPointersSlidingWindow02 {
    public static void main(String[] args) {
        TowPointersSlidingWindow02 T = new TowPointersSlidingWindow02();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for(int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for(int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println(T.solution(arr1, arr2));
    }

    private ArrayList<Integer> solution(int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1 = 0, p2 = 0;
        while(p1 < arr1.length && p2 < arr2.length) {
            if(arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1++]);
                p2++;
            } else if (arr1[p1] < arr2[p2]) p1++;
            else p2++;
        }

        return answer;
    }
}
