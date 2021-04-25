import java.util.Scanner;

public class String08Palindrome {
    public static void main(String[] args) {
        String08Palindrome T = new String08Palindrome();

        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        System.out.println(T.solution(str));
    }

    private String solution(String str) {
        String answer = "YES";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equals(tmp)) answer = "YES";
        return answer;
    }
}
