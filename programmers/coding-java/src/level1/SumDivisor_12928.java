package level1;

import static java.lang.StrictMath.sqrt;

/*
    약수의 합
 */
public class SumDivisor_12928 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(12));
        System.out.println(sol.solution(5));
        System.out.println(sol.solution(0));
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;

//            for (int i = 1; i <= n; i++) {
//                if (n % i == 0)
//                    answer += i;
//            }
//            return answer;

            for (int i = 1; i <= n/2; i++) {
                if (n % i == 0)
                    answer += i;
            }
            return answer + n;
        }
    }
}
