import java.util.Scanner;

public class String03 {
    public static void main(String[] args) {
        String03 T = new String03();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }

    private String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len > m) {
                m = len;
                answer = tmp;
            }
            str =  str.substring(pos + 1);
        }
        // last word
        if(str.length() > m) {
            return str;
        }
        return answer;
    }

//    private String solution(String str) {
//        String answer = "";
//        int m = Integer.MIN_VALUE;
//        String[] s = str.split(" ");
//        for(String x: s) {
//            int len = x.length();
//            if(len > m) {
//                m = len;
//                answer = x;
//            }
//        }
//        return answer;
//    }
}
