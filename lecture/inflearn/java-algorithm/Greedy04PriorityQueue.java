import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
최대 수입 스케쥴(Priority Queue) - 최대로 벌 수 있는 수입
N
M D (Money, Day)

6
50 2
20 1
40 2
60 3
30 3
30 1

150

 */

class Lecture implements Comparable<Lecture> {
    int money;
    int time;

    public Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.time - this.time; // 내림차순
    }
}
public class Greedy04PriorityQueue {
    public static int N, max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Greedy04PriorityQueue T = new Greedy04PriorityQueue();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int m = sc.nextInt();
            int t = sc.nextInt();
            arr.add(new Lecture(m, t));
            if(t > max) max = t;
        }
        System.out.println(T.solution(arr));
    }

    private int solution(ArrayList<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); // 큰 값을 우선
        //PriorityQueue<Integer> pQ = new PriorityQueue<>(); // 작은 값을 우선

        Collections.sort(arr);

        int j = 0;
        for(int i = max; i >= 1; i--) {
            for( ; j < N; j++) {
                if(arr.get(j).time < i) break; // day 가 띄엄띄엄 있을수도 있으니까..
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) {
                answer += pQ.poll(); // 가장 큰 값
            }
        }

        return answer;
    }
}
