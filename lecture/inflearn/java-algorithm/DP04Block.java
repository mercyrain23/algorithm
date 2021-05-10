import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
가장 높은 탑 쌓기

N
벽돌 밑면의 넓이, 높이, 무게

5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2

4
 */
class Block implements Comparable<Block>{
    int l, h, w;

    public Block(int l, int h, int w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Block o) {
        return o.l - this.l; // 내림차순
    }
}
public class DP04Block {
    static int[] dy;
    public static void main(String[] args) {
        DP04Block T = new DP04Block();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dy = new int[N];
        ArrayList<Block> arr = new ArrayList<Block>();
        for(int i = 0; i < N; i++) {
            int l = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Block(l, h, w));
        }
        System.out.println(T.solution(arr));
    }

    private int solution(ArrayList<Block> arr) {
        int answer = 0;
        Collections.sort(arr);

        dy[0] = arr.get(0).h;
        answer = dy[0];
        for(int i = 1; i < arr.size(); i++) {
            int max = 0;
            for(int j = i - 1; j >=0; j--) {
                if(arr.get(j).w > arr.get(i).w && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + arr.get(i).h;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
}
