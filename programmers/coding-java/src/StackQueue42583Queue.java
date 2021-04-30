import java.util.LinkedList;
import java.util.Queue;

public class StackQueue42583Queue {
    public static void main(String[] args) {
        StackQueue42583Queue T = new StackQueue42583Queue();

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10};

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(T.solution(bridge_length, weight, truck_weights));

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < bridge_length-1; i++) {
            queue.offer(0);
        }

        int count = 1;
        queue.offer(truck_weights[0]); // 첫번째 차 진입
        int sum_weight = truck_weights[0];

        int truck_idx = 1;
        while(!queue.isEmpty() && (truck_idx < truck_weights.length)) {
            count++;

            int truck = queue.poll();
            sum_weight -= truck;

            if(sum_weight + truck_weights[truck_idx] > weight) {
                queue.offer(0);
            } else {
                queue.offer(truck_weights[truck_idx]);
                sum_weight += truck_weights[truck_idx];
                truck_idx++;
            }
        }

        int queue_size = queue.size();
        for(int i = 0; i < queue_size; i++) {
            count++;
            queue.poll();
        }

        return count;
    }
}
