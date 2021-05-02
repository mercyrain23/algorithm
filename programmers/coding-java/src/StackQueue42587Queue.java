import java.util.LinkedList;
import java.util.Queue;

class Print {
    int priority;
    int idx;

    public Print(int priority, int idx) {
        this.priority = priority;
        this.idx = idx;
    }
}
public class StackQueue42587Queue {
    public static void main(String[] args) {
        StackQueue42587Queue T = new StackQueue42587Queue();

        int[] priorities = {2, 1, 3, 2};
        int location = 2;

//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;

        System.out.println(T.solution(priorities, location));
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Print> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new Print(priorities[i], i));
        }
        while(!queue.isEmpty()) {
            Print print = queue.poll();
            for(Print p : queue) {
                if(p.priority > print.priority) {
                    queue.offer(print);
                    print = null;
                    break;
                }
            }
            if(print != null) {
                answer++;
                if(print.idx == location) {
                    return answer;
                }
            }
        }

        return answer;
    }
}
