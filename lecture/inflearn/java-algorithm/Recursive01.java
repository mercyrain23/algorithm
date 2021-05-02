public class Recursive01 {
    public static void main(String[] args) {
        Recursive01 T = new Recursive01();

        T.recursive(3);
    }

    public void recursive(int n) {
        if(n == 0) {
            return;
        }
//        System.out.print(n + " "); // 3 2 1
        recursive(n - 1);
        System.out.print(n + " "); // 1 2 3
    }
}
