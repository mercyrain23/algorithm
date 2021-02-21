package level1;

/*
    짝수와 홀수
 */
public class EvenOrOdd_12937 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(0));
        System.out.println(sol.solution(3));
        System.out.println(sol.solution(-3));
        System.out.println(sol.solution(4));
    }

    static class Solution {
        public String solution(int num) {
//        String answer = "Even";
//        if (num != 0 && (num % 2 == 1 || num % 2 == -1))
//            answer = "Odd";
//        return answer;
            return (num % 2 == 0) ? "Even" : "Odd";
        }
    }
}

