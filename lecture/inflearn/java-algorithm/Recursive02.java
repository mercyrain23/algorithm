// 재귀함수 - 이진수 출력
public class Recursive02 {
    public static void main(String[] args) {
        Recursive02 T = new Recursive02();

        int num = 11;

        T.recursive(num);

    }

    public void recursive(int n) {
        if(n == 0) {
            return;
        }
//        int val = n % 2;
//        recursive(n / 2);
//        System.out.print(val);

        recursive(n / 2);
        System.out.print(n % 2);
    }
}
