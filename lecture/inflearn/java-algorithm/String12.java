import java.util.Scanner;

public class String12 {
    public static void main(String[] args) {
        String12 T = new String12();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();

        System.out.println(T.solution(N, str));
    }

    private String solution(int n, String str) {
        String answer = "";
        for(int i = 0; i < n; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            str = str.substring(7);

            int num = Integer.parseInt(tmp, 2); // 2진수 -> 10진수
            answer += (char)num;
//            System.out.println(tmp + " " + num);
        }

        return answer;
    }

}
