import java.util.Scanner;
import java.util.Stack;

public class StackQueue03 {
    public static void main(String[] args) {
        StackQueue03 T = new StackQueue03();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int K = sc.nextInt();
        int[] moves = new int[K];
        for(int i = 0; i < K; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(T.solution(board, moves));
    }

    private int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int pos: moves) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][pos-1] != 0) {
                    int tmp = board[i][pos-1];
                    board[i][pos-1] = 0;

                    if(!stack.isEmpty() && stack.peek() == tmp) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break; // 중요
                }
            }
        }

        return answer;
    }
}
