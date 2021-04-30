import java.util.Arrays;
import java.util.Stack;

public class StackQueue42584Stack {
    public static void main(String[] args) {
        StackQueue42584Stack T = new StackQueue42584Stack();

        int[] prices = {1, 2, 3, 2, 3};

        int[] result = T.solution(prices);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }

        return answer;
    }
}
