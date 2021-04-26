import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
5
14 18
12 15
15 20
20 30
5 14
 */
class Time {
    int time;
    char state;

    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }
}
public class Greedy03 {
    public static void main(String[] args) {
        Greedy03 T = new Greedy03();

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
