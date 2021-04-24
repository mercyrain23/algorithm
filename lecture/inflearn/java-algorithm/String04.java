import java.util.ArrayList;
import java.util.Scanner;

public class String04 {
    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
//        for(String x: str) {
//            String st = new StringBuilder(x).reverse().toString();
//            answer.add(st);
//        }

        for(String x: str) {
            char[] arr = x.toCharArray();
            int lt = 0, rt = arr.length - 1;
            while(lt < rt) {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
            answer.add(String.valueOf(arr));
        }
        return answer;
    }
    public static void main(String[] args) {
        String04 T = new String04();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];

        for(int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        for(String x: T.solution(n, str)) {
            System.out.println(x);
        }
    }
}
