import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
동시에 존재하는 최대 인원
시간상 흐름 - start 만나면 +1, end 는 -1 => 시간으로 정렬하고, 시간이 같을 때는 e, s 순으로 정렬 (s를 먼저 체크하면 max값에 영향을 줌)

5
14 18
12 15
15 20
20 30
5 14

2
 */
class Time {
    int time;
    char state;

    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }
}
public class Greedy03Sort {
    public static void main(String[] args) {
        Greedy03Sort T = new Greedy03Sort();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int st = sc.nextInt();
            int et = sc.nextInt();
            arr.add(new Time(st, 's')); // start
            arr.add(new Time(et, 'e')); // end
        }
        System.out.println(T.solution(arr, N));
    }

    private int solution(ArrayList<Time> arr, int n) {
        int answer = Integer.MIN_VALUE;
        int count = 0;

        Collections.sort(arr, comp);

        for(Time t: arr) {
            if(t.state == 's') count++;
            else count--;
            answer = Math.max(answer, count);
        }
        return answer;
    }
    Comparator<Time> comp = new Comparator<Time>() {
        @Override
        public int compare(Time o1, Time o2) {
            if(o1.time == o2.time) return o1.state - o2.state;
            else return o1.time - o2.time;
        }
    };

}
