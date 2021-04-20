import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AssemblyLine {

    /*
2
1 3 1 2
10 2
=> 4

3
1 3 1 2
10 2 2 1
2 2
=> 6
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(bf.readLine());

        int[][] AB = new int[N+1][N+1];
        int[] X = new int[N+1];
        int[] Y = new int[N+1];

        for(int i = 1; i <= N; i++) {
            String tmp = bf.readLine();
            String[] num = tmp.split(" ");
            AB[0][i-1] = Integer.valueOf(num[0]);
            AB[1][i-1] = Integer.valueOf(num[1]);
            if(i < N) {
                X[i-1] = Integer.valueOf(num[2]);
                Y[i-1] = Integer.valueOf(num[3]);
            }
        }
        for(int i = 1; i <= N; i++) {
            AB[0][i] = Math.min(AB[0][i-1], AB[1][i-1] + Y[i-1]) + AB[0][i];
            AB[1][i] = Math.min(AB[1][i-1], AB[0][i-1] + X[i-1]) + AB[1][i];
        }

        System.out.println(Math.min(AB[0][N], AB[1][N]));
    }

}
