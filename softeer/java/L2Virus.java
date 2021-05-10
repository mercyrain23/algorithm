import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
바이러스
바이러스가 숙주의 몸속에서 1초당 P배씩 증가한다. 처음에 바이러스 K마리가 있었다면 N초 후에는 총 몇 마리의 바이러스로 불어날까

2 3 2

=> 18
 */
public class L2Virus {
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
