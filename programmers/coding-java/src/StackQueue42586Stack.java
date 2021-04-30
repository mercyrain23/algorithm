import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackQueue42586Stack {
    public static void main(String[] args) {
        StackQueue42586Stack T = new StackQueue42586Stack();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] result = T.solution(progresses, speeds);

        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < progresses.length; i++) {

            int days = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) {
                days++;
            }

            if(!stack.isEmpty()) {
                count++;
                if(stack.peek() < days) {
                    stack.pop();
                    result.add(count);
                    count = 0;
                } else {
                    continue;
                }
            }
            stack.push(days);
        }
        if(!stack.isEmpty()) {
            count++;
            result.add(count);
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
