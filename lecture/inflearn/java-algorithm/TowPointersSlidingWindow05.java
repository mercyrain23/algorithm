import java.util.Scanner;

public class TowPointersSlidingWindow05 {
    public static void main(String[] args) {
        TowPointersSlidingWindow05 T = new TowPointersSlidingWindow05();

        Scanner sc = new Scanner(System.in);
        int Num = sc.nextInt();

        System.out.println(T.solution(Num));
    }

    private int solution(int num) {
        int answer = 0, cnt = 1;

        num--; // num - 1
        while(num > 0) {
            cnt++;
            num = num - cnt; // num - 2, num - 3, num - 4 ....
            if(num % cnt == 0) answer++;
        }
        return answer;
    }
}
