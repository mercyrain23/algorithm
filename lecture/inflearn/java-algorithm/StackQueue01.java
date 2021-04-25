import java.util.Scanner;
import java.util.Stack;

public class StackQueue01 {
    public static void main(String[] args) {
        StackQueue01 T = new StackQueue01();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }

    private String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '(') {
                stack.push(arr[i]);
            } else {
                if (stack.isEmpty())
                    return "NO";
                stack.pop();
            }
        }
        if(!stack.isEmpty()) {
            return "NO";
        }

        return answer;
    }
}
