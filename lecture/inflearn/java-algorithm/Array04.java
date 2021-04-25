import java.util.Scanner;

public class Array04 {

    public static void main(String[] args) {
        Array04 T = new Array04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        for(int i: T.solution(n))
//            System.out.print(i + " ");
        T.solution(n);
    }

    public void solution(int n) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b + " ");
        for(int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
        }
    }

//    private int[] solution(int n) {
//        int[] answer = new int[n];
//        answer[0] = 1;
//        answer[1] = 1;
//        for(int i = 2; i < n; i++) {
//            answer[i] = answer[i-2] + answer[i-1];
//        }
//
//        return answer;
//    }
}
