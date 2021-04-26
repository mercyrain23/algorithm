import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Body implements Comparable<Body> {
    int height, weight;

    public Body(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Body o) {
        return o.height - this.height; // 내림차순(양수 리턴)
    }
}
public class Greedy01Sort {
    public static void main(String[] args) {
        Greedy01Sort T = new Greedy01Sort();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Body(h, w));
        }
        System.out.println(T.solution(arr, N));
    }

    private int solution(ArrayList<Body> arr, int n) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        Collections.sort(arr);

        for(Body body: arr) {
            if(body.weight > max) {
                answer++;
                max = body.weight;
            }
        }

        return answer;
    }
}
