import java.util.HashMap;
import java.util.Scanner;

public class HashMapTreeSet02HashMap {
    public static void main(String[] args) {
        HashMapTreeSet02HashMap T = new HashMapTreeSet02HashMap();

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.print(T.solution(str1, str2));
    }

    private String solution(String str1, String str2) {
        String answer = "YES";

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char ch: str2.toCharArray()) {
            if(!map.containsKey(ch) || map.get(ch) == 0) {
                return "NO";
            }
            map.put(ch, map.get(ch) - 1);
        }
        return answer;
    }
}
