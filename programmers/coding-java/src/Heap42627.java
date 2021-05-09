import java.util.*;

public class Heap42627 {
    public static void main(String[] args) {
        Heap42627 T = new Heap42627();

        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(T.solution(jobs));

    }

    public int solution(int[][] jobs) {
        int answer = 0;

//        PriorityQueue<int[]> pQ = new PriorityQueue<>(Comparator.comparingInt((int[] arr) -> arr[1]));
//        Arrays.sort(jobs, Comparator.comparingInt((int[] arr) -> arr[0]));

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

//        for(int[] job : jobs){
//            System.out.println(job[0] + " " + job[1]);
//        }

        int jobIdx = 0;
        int count = 0;
        int end = 0;

        while(count < jobs.length) {

            while(jobIdx < jobs.length && jobs[jobIdx][0] <= end) {
                pQ.offer(jobs[jobIdx++]);
            }

            if(pQ.isEmpty()) {
                end = jobs[jobIdx][0];
            } else {
                int[] tmp = pQ.poll();
                answer += tmp[1] + end - tmp[0];
                end += tmp[1];
                count++;

            }
        }

        return (int) Math.floor(answer / jobs.length);
    }
}
