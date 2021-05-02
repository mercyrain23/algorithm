// 재귀함수 - 피보나치. 메모이제이션
public class Recursive04Fibonacci {

    static int[] fibo;
    public static void main(String[] args) {
        Recursive04Fibonacci T = new Recursive04Fibonacci();

        int num = 45;
//        System.out.println(T.recursive(num));
//        for(int i = 1; i < num; i++) {
//            System.out.print(T.recursive(i) + " ");
//        }

        fibo = new int[num+1];
        T.recursive(num);
        for(int i = 1; i <= num; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
    public int recursive(int n) {
        if(fibo[n] > 0) {
            return fibo[n];
        }
        if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 1;
        else {
            return fibo[n] = recursive(n - 2) + recursive(n - 1);
        }
    }


//    public int recursive(int n) {
//        if(n == 1) return fibo[n] = 1;
//        else if(n == 2) return fibo[n] = 1;
//        else {
//            return fibo[n] = recursive(n - 2) + recursive(n - 1);
//        }
//    }

//    public int recursive(int n) {
//        if(n == 1) return 1;
//        else if(n == 2) return 1;
//        else {
//            return recursive(n - 2) + recursive(n - 1);
//        }
//    }
}
