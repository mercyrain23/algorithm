import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sort42748 {
    public static void main(String[] args) {
        Sort42748 T = new Sort42748();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] result = T.solution(array, commands);
        System.out.println(Arrays.toString(result));
    }
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int idx = 0;
        for(int[] cmd: commands) {
            ArrayList<Integer> tmp = new ArrayList<>();

            // int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            for(int i = cmd[0]-1; i < cmd[1]; i++) {
                tmp.add(array[i]);
            }
            Collections.sort(tmp);
            answer[idx++] = tmp.get(cmd[2]-1);
        }

        return answer;
    }
}
