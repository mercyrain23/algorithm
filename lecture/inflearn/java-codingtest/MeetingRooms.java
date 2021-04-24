import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/*
[[0,30],[5,10],[15,20]] -> false
[[7,10],[2,4]] -> true
 */
class Interval {
    int start;
    int end;
    Interval() {
        this.start = 0;
        this.end = 0;
    }
    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

public class MeetingRooms {

    public static void main(String[] args) {
        MeetingRooms mr = new MeetingRooms();

//        Interval in1 = new Interval(15, 20);
//        Interval in2 = new Interval(5, 10);
//        Interval in3 = new Interval(0, 30);

        Interval in1 = new Interval(7, 10);
        Interval in2 = new Interval(2, 4);

        Interval[] intervals = {in1, in2};
        System.out.println(mr.solve(intervals));
    }

    private boolean solve(Interval[] intervals) {
        if(intervals == null) {
           return false; 
        }
        //print(intervals);
        Arrays.sort(intervals, Comp);

        print(intervals);

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[0].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }

    Comparator<Interval> Comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start; // 오름차순
        }
    };

    private void print(Interval[] intervals) {
        for(int i = 0; i < intervals.length; i++) {
            Interval in = intervals[i];
            System.out.println(in.start + " " + in.end);
        }
    }
}
