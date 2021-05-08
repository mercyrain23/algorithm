/*
부분집합 구하기

3

1 2 3
1 2
1 3
1
2 3
2
3
 */
public class DFS06Subset {
    static int N;
    static int[] check;
    
    public static void main(String[] args) {
        DFS06Subset T = new DFS06Subset();

        N = 3;
        check = new int[N+1];
        T.DFS(1); // start 숫자가 1을 의미
    }

    private void DFS(int L) {
        if(L == N+1) {
            String tmp = "";
            for(int i = 1; i <= N; i++) {
                if(check[i] == 1) {
                    tmp += (i + " ");
                }
            }
            if(tmp.length() > 0) System.out.println(tmp);

        } else {
            check[L] = 1;
            DFS(L+1);
            check[L] = 0;
            DFS(L+1);
        }
    }
}

/*
// DFS - 부분집합 구하기
public class Tree02SubDFS {
    static int n;
    static int[] check;

    // 공집합을 제외한 부분집합 구하기
    public static void main(String[] args) {
        Tree02SubDFS T = new Tree02SubDFS();

        n = 3;
        check = new int[n+1];
        T.DFS(1);

    }

    private void DFS(int L) {
        if(L == n+1) {
            for(int i = 0; i < check.length; i++) {
                if(check[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            check[L] = 1;
            DFS(L + 1); // left
            check[L] = 0;
            DFS(L + 1); // right
        }
    }

}

 */