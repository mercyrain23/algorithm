import java.util.Scanner;

//합이 같은 부분집합
/*
6
1 3 5 6 7 10

YES
 */
public class DFSBFS01DFSSubset {
    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;

    public static void main(String[] args) {
        DFSBFS01DFSSubset T = new DFSBFS01DFSSubset();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }

    private void DFS(int L, int sum, int[] arr) {
        if(flag) return;
        if(sum > (total/2)) return;
        if(L == n) {
            if((total/2) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L+1, sum + arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

}
