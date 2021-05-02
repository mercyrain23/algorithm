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
