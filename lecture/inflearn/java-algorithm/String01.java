import java.util.Scanner;

public class String01 {
//public class Main {
    public int solution(String str, char ch) {
        int answer = 0;

        str = str.toUpperCase();
        ch = Character.toUpperCase(ch);

//        for(int i = 0; i < str.length(); i++) {
//            if(str.charAt(i) == ch) {
//                answer++;
//            }
//        }
        for(char c: str.toCharArray()) {
            if(c == ch) {
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String01 T = new String01();
        //Main T = new Main();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(T.solution(str, c));
    }
}
