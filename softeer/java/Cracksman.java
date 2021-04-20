import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cracksman {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int weight = Integer.valueOf(st.nextToken());
        int num = Integer.valueOf(st.nextToken());

        long[] arr = new long[(int) Math.pow(10, 4) + 1];

        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.valueOf(st.nextToken());
            int P = Integer.valueOf(st.nextToken());

            arr[P] += M;
        }

        int result = 0;
        for(int i = (int) Math.pow(10, 4); i > 0; i--) {
            if(arr[i] != 0 && arr[i] <= weight) {
                result += i * arr[i];
                weight -= arr[i];
            } else if ( arr[i] > weight ){
                result += i * weight;
                break;
            }
        }
        System.out.println(result);
    }
}
