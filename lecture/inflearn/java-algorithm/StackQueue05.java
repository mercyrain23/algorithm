import java.util.Scanner;
import java.util.Stack;

public class StackQueue05 {
    public static void main(String[] args) {
        StackQueue05 T = new StackQueue05();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(T.solution(str));
    }

    private int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                stack.pop();
                if(str.charAt(i-1) == '(') { // lazer
                    answer += stack.size();
                } else { // 막대기 끝
                    answer++;
                }
            }
        }
        return answer;
    }
}
