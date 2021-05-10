import java.util.Arrays;
import java.util.Scanner;
/*

3
1 3
2 4
3 5

=> 2
 */
public class L3Room {
    public static void main(String[] args) {
        L3Room T = new L3Room();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] room = new int[N][2];

        for(int i = 0; i < N; i++) {
            room[i][0] = sc.nextInt();
            room[i][1] = sc.nextInt();
        }

        Arrays.sort(room, ((o1, o2) -> {
            return o1[1] - o2[1];
        }));

//        for(int[] x: room) {
//            System.out.println(Arrays.toString(x));
//        }
         int answer = 1;
         int end = room[0][1];
         for(int i = 1; i < N; i++) {
             if(room[i][0] >= end) {
                 answer++;
                 end = room[i][1];
             }
         }
        System.out.println(answer);
    }
}
