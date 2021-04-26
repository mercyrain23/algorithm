import java.util.*;

/*
5
1 4
2 3
3 5
4 6
5 7
 */
class Room {
    int start, end;

    public Room(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Greedy02Sort {
    public static void main(String[] args) {
        Greedy02Sort T = new Greedy02Sort();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Room> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Room(s, e));

        }
        System.out.println(T.solution(arr, N));
    }

    private int solution(ArrayList<Room> arr, int n) {
        int answer = 0;

        Collections.sort(arr, comp);
//        for(Room r: arr) {
//            System.out.println(r.start + " " + r.end);
//        }

        int end = 0;
        for(Room r: arr) {
            if(r.start >= end) {
                answer++;
                end = r.end;
            }
        }
        return answer;
    }
    Comparator<Room> comp = new Comparator<Room>() {
        @Override
        public int compare(Room o1, Room o2) {
            if(o1.end == o2.end) return o1.start - o1.start;
            else return o1.end - o2.end; // 오름차순
        }
    };
}
