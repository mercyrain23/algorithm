// 재귀함수 - 팩토리얼
public class Recursive03Factorial {
    public static void main(String[] args) {
        Recursive03Factorial T = new Recursive03Factorial();

        int num = 5;
        System.out.println(T.recursive(num));
    }
    public int recursive(int n) {
        if(n == 1) {
            return 1;
        }
        return n * recursive(n-1);
    }
}
