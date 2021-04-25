import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackQueue06 {
    public static void main(String[] args) {
        StackQueue06 T = new StackQueue06();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(T.solution(N, K));
    }

    private int solution(int N, int K) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        while(!queue.isEmpty()) {
            for(int i = 1; i < K; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if(queue.size() == 1) answer = queue.poll();
        }
        return answer;
    }
}
