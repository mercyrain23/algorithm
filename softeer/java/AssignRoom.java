import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AssignRoom {
    /*
3
1 3
2 4
3 5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        StringTokenizer st;

        int[][] lecture = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lecture[i][0] = Integer.valueOf(st.nextToken());
            lecture[i][1] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(lecture, (o1, o2) -> {
            //return Integer.compare(o2[0], o2[1]);
            return o1[1] - o2[1]; //오름차순
        });

        int cnt = 1;
        int end = lecture[0][1];
        for(int i = 1; i < N; i++) {
            if(lecture[i][0] >= end) {
                cnt++;
                end = lecture[i][1];
            }
        }
        System.out.println(cnt);

//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < 2; j++) {
//                System.out.print(lecture[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}

/*
3
2 4
3 5
1 3
 */