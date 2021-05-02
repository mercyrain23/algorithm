import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Sort42747Hindex {
    public static void main(String[] args) {
        Sort42747Hindex T = new Sort42747Hindex();

        int[] citations = {3, 0, 6, 1, 5}; // 3
//        int[] citations = {22, 42}; // 2
//        int[] citations = {0}; // 0
//        int[] citations = {25, 8, 5, 3, 3}; // 3

        System.out.println(T.solution(citations));
        System.out.println(T.solution2(citations));
    }

    public int solution(int[] citations) {
        int answer = 0;

        Integer[] nums = new Integer[citations.length];
        for(int i = 0; i < citations.length; i++) {
            nums[i] = citations[i];
        }
        Arrays.sort(nums, Collections.reverseOrder());

        for(int i = 0; i < nums.length; i++) {
            int index = i + 1;
//            if(index < nums[i]) {
//                answer++;
//            } else if (index >= nums[i]) {
//                if( index == nums[i]) {
//                    answer++;
//                }
//                break;
//            }

            answer++;
            if(index >= nums[i]) {
                if(index > nums[i])
                    answer -= 1;
                break;
            }
        }

        //System.out.println(Arrays.toString(nums));
        return answer;
    }

    public int solution2(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--) {
            int min = Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}
