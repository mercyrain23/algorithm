import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Heap42628 {
    public static void main(String[] args) {
        Heap42628 T = new Heap42628();

        String[] operations = {"I 16","D 1"};
//        String[] operations = {"I 7","I 5","I -5","D -1"};

        System.out.println(Arrays.toString(T.solution(operations)));

    }

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        PriorityQueue<Integer> pQR = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < operations.length; i++) {
            String[] arr = operations[i].split(" ");
            String cmd = arr[0].toString();
            int num = Integer.parseInt(arr[1]);

            if (pQ.isEmpty() && cmd.equals("D")) {
                continue;
            }

            if (cmd.equals("I")) {
                pQ.offer(num);
                pQR.offer(num);
                continue;
            }

            if (num < 0) {
                int min = pQ.poll();
                pQR.remove(min);
                continue;
            } else {
                int max = pQR.poll();
                pQ.remove(max);
                continue;
            }
        }

        if (pQ.size() > 0) {
            answer[0] = pQR.poll();
            answer[1] = pQ.poll();
        }

        return answer;
    }
}
