package level1;

public class String_12918 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("a234"));
        System.out.println(sol.solution("1234"));
    }

    static class Solution {
        public boolean solution(String s) {
            boolean answer = false;
            //  if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");

            if (s.length() == 4 || s.length() == 6) {
                try {
                    Integer.parseInt(s);
                    answer = true;
                } catch (Exception e) {
                }
            }
            return answer;
        }
    }
}
