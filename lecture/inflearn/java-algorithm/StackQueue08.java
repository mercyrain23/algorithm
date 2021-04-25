import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    int id;
    int priority;
    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}
public class StackQueue08 {
    public static void main(String[] args) {
        StackQueue08 T = new StackQueue08();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(N, M, arr));

    }

    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            queue.offer(new Person(i, arr[i]));
        }
        while(!queue.isEmpty()) {
            Person tmp = queue.poll();
            for(Person x: queue) {
                if(x.priority > tmp.priority) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {
                answer++;
                if(tmp.id == m) return answer;
            }
        }
        return answer;
    }
}
