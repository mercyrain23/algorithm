import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/*
3
1 3 5
5
2 3 6 7 9
 */
public class TowPointersSlidingWindow01 {
    public static void main(String[] args) {
        TowPointersSlidingWindow01 T = new TowPointersSlidingWindow01();

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
        int p1 = 0, p2 = 0;
        while(p1 < arr1.length && p2 < arr2.length) {
            if(arr1[p1] < arr2[p2]) answer.add(arr1[p1++]);
//            else if(arr1[p1] > arr2[p2]) answer.add(arr2[p2++]);
            else answer.add(arr2[p2++]);
        }
        while(p1 < arr1.length) {
            answer.add(arr1[p1++]);
        }
        while(p2 < arr2.length) {
            answer.add(arr2[p2++]);
        }

        return answer;
    }


}
