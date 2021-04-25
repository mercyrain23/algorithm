import java.util.ArrayList;
import java.util.Scanner;

public class Array05PrimeNumberEratosthenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int answer = 0;
        int[] arr = new int[num+1];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i <= num; i++) {
            if(arr[i] == 0) {
                answer++;
                list.add(i);
                for(int j = i; j <= num; j = j+i) {
                    arr[j] = 1;
                }
            }

        }
        System.out.println("answer : " + answer);

        for(int n: list) {
            System.out.print(n + " ");
        }
    }
}
