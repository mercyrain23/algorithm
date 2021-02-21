package level1;

public class StrToInt_12925 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("1234"));
        System.out.println(sol.solution("-1234"));
        System.out.println(sol.solution("+1234"));

    }

    static class Solution {
        public int solution(String s) {
//            return Integer.parseInt(s);

            int result = 0;
            boolean sign = true;
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '-') {
                    sign = false;
                } else if (ch != '+'){
                    result = (ch - '0') + (result * 10);

                }
            }
            return sign ? result : -1 * result;
        }
    }
}
