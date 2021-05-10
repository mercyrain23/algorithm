import java.util.Arrays;
import java.util.Scanner;

/*
8단 변속기

1 2 3 4 5 6 7 8

8 7 6 5 4 3 2 1

8 7 5 6 4 3 2 1

=> ascending
 */
public class L2SpeedTransmission {
    public static void main(String[] args) {
        L2SpeedTransmission T = new L2SpeedTransmission();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] arr = str.split(" ");

        boolean isAsc = true;
        boolean isDesc = true;

        for(int i = 0; i < arr.length-1; i++) {
            int num1 = Integer.parseInt(arr[i]);
            int num2 = Integer.parseInt(arr[i+1]);

            if(num1 < num2) {
                isDesc = false;
            }
            if(num1 > num2) {
                isAsc = false;
            }
        }
        if(isAsc) System.out.println("ascending");
        else if(isDesc) System.out.println("descending");
        else System.out.println("mixed");
    }
}
