import java.util.HashMap;
import java.util.Scanner;

public class HashMapTreeSet01HashMap {
    public static void main(String[] args) {
        HashMapTreeSet01HashMap T = new HashMapTreeSet01HashMap();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n, str));
    }

    private char solution(int n, String str) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x: str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for(char key: map.keySet()) {
//            System.out.println(x);
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }
}
