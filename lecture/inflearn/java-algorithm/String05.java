import java.util.Scanner;

public class String05 {
    public static void main(String[] args) {
        String05 T = new String05();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));

    }

    private String solution(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;

        while(left < right) {
            if(!Character.isAlphabetic(arr[left])) {
                left++;
            }
            if(!Character.isAlphabetic(arr[right])) {
                right--;
            }
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        //return arr.toString();
        return String.valueOf(arr);
    }
}
