package level1;

import java.util.Arrays;

public class NumberArray_12932 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(12345)));
        System.out.println(Arrays.toString(sol.solution(10000)));
        System.out.println(Arrays.toString(sol.solution(123546789)));
    }

    static class Solution {
        public long[] solution(long n) {
            int length = String.valueOf(n).length();
            long[] answer = new long[length];

            int i = 0;
            while(n > 0) {
                answer[i] = n % 10;
                n /= 10;
                i++;
            }

            return answer;
        }
    }
}
