import java.util.Arrays;
import java.util.Collections;

public class ExhaustiveSearch42840 {
    public static void main(String[] args) {
        ExhaustiveSearch42840 T = new ExhaustiveSearch42840();

        System.out.println(Arrays.toString(T.solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1,3,2,4,2})));
    }

    public int[] solution(int[] answers) {
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == num1[i % 5]) cnt1++; // i % num1.length
            if(answers[i] == num2[i % 8]) cnt2++;
            if(answers[i] == num3[i % 10]) cnt3++;
        }

        Integer[] cnt = {cnt1, cnt2, cnt3};
        Arrays.sort(cnt, Collections.reverseOrder());


        String str = "";
        if(cnt[0] == cnt1) {
            str += " 1";
        }
        if(cnt[0] == cnt2) {
            str += " 2";
        }
        if(cnt[0] == cnt3) {
            str += " 3";
        }


        String[] arr = str.trim().split(" ");
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
            answer[i] = Integer.valueOf(arr[i]);
        }
        return answer;
    }

    public void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
