import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Virus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Long.valueOf(st.nextToken());
        long P = Long.valueOf(st.nextToken());
        long N = Long.valueOf(st.nextToken());

        long answer = K;
        for(int i = 0; i < N; i++) {
            answer *= P;
            answer %= 1000000007;
        }
        //int value = answer % 1000000007;
        System.out.println(answer);
    }
}
