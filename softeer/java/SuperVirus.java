import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SuperVirus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Long.valueOf(st.nextToken());
        long P = Long.valueOf(st.nextToken());
        long N = Long.valueOf(st.nextToken()); // 0.1s

        long answer = K * recursive(P, N*10) % 1000000007;
        System.out.println(answer);
    }
    private static long recursive(long P, long N) {
        if(N == 0) {
            return 1;
        }

        long val = recursive(P, N/2);
        val *= val;
        val %= 1000000007;

        if (N % 2 == 0) {
            return val;
        } else {
            return val * P % 1000000007;
        }
    }
}
