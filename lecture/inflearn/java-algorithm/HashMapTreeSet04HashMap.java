import java.util.HashMap;
import java.util.Scanner;

public class HashMapTreeSet04HashMap {
    public static void main(String[] args)  {
        HashMapTreeSet04HashMap T = new HashMapTreeSet04HashMap();

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println(T.solution(str1, str2));
    }

    private int solution(String str1, String str2) {
        int answer = 0;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char ch: str2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        // init
        int len = str2.length() - 1;
        for(int i = 0; i < len; i++) {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
        }

        int lt = 0;
        for(int rt = len; rt < str1.length(); rt++) {
            map1.put(str1.charAt(rt), map1.getOrDefault(str1.charAt(rt), 0) + 1);
            if(map1.equals(map2)) answer++;

            map1.put(str1.charAt(lt), map1.get(str1.charAt(lt)) - 1);
            if(map1.get(str1.charAt(lt)) == 0) {
                map1.remove(str1.charAt(lt));
            }
            lt++;
        }

        return answer;
    }

}
