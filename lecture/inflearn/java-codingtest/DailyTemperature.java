import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = solve(nums);

        System.out.println("-----------------------");
        for(int n: res) {
            System.out.println(n + " ");
        }

    }

    private static int[] solve(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        // stack 에 index push
        for(int i = 0; i < nums.length; i++) {
            while(!stack.empty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                result[index] = i - index;
                System.out.println(i + " " + index);
            }
            stack.push(i);
        }

        return result;
    }
}
