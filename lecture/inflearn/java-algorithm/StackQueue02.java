import java.util.Scanner;
import java.util.Stack;

public class StackQueue02 {
    public static void main(String[] args) {
        StackQueue02 T = new StackQueue02();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }

    private String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char ch: str.toCharArray()) {
            if(ch == ')') {
                while(stack.pop() != '(');
            } else {
                stack.push(ch);
            }
        }
        for(char ch: stack) {
            //System.out.print(ch);
            answer += ch;
        }

        return answer;
    }
}
