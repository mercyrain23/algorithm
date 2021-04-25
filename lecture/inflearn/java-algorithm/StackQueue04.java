import java.util.Scanner;
import java.util.Stack;

public class StackQueue04 {
    public static void main(String[] args) {
        StackQueue04 T = new StackQueue04();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(T.solution(str));
    }

    private int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(char ch: str.toCharArray()) {
            if(Character.isDigit(ch)) {
                stack.push(ch - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(ch == '+') stack.push(lt + rt);
                else if(ch == '-') stack.push(lt - rt);
                else if(ch == '*') stack.push(lt * rt);
                else if(ch == '/') stack.push(lt / rt);
            }
        }
        answer = stack.get(0);

        return answer;
    }
}
