import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap42626 {
    public static void main(String[] args) {
        Heap42626 T = new Heap42626();

//        int[] scoville = {1, 2, 3, 9, 10, 12};
       int[] scoville = {1, 1};
        int K = 7;

        System.out.println(T.solution(scoville, K));
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++) {
            pQ.offer(scoville[i]);
        }

        while(pQ.size() > 1 && pQ.peek() < K) {
            int food1 = pQ.poll();
            int food2 = pQ.poll();

            pQ.offer(food1 + (2 * food2));
            answer++;

//            System.out.println(pQ);
        }

        if(!pQ.isEmpty() && pQ.peek() < K) {
            return -1;
        }

        return answer;
    }

}
