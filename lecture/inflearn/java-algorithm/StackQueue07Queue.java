import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackQueue07Queue {
    public static void main(String[] args) {
        StackQueue07Queue T = new StackQueue07Queue();

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(T.solution(str1, str2));
    }

    private String solution(String str1, String str2) {
        String answer = "YES";

        Queue<Character> queue = new LinkedList<>();
        for(char ch: str1.toCharArray()) queue.offer(ch);
        for(char ch: str2.toCharArray()) {
            if(queue.contains(ch)) {
                if(ch != queue.poll()) {
                    return "NO";
                }
            }
        }
//        if(queue.size() > 0) {
//            return "NO";
//        }
        if(!queue.isEmpty()) {
            return "NO";
        }
        return answer;
    }
}
