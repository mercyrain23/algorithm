import java.util.Scanner;
/*
지도 자동 구축
0단계 : 4 - 2
1단계 : 9 - 3
2단계 : 25 - 5

1

=> 9
 */
public class L2MapAutoCreation {
    public static void main(String[] args) {
        L2MapAutoCreation T = new L2MapAutoCreation();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int answer = 2;
        for(int i = 0; i < N; i++) {
            answer = 2 * answer - 1;
        }
        System.out.println(answer * answer);
    }
}
