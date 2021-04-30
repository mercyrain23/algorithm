import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Hash42576 {
    public static void main(String[] args) {
        Hash42576 T = new Hash42576();

//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(T.solution(participant, completion));
        System.out.println(T.solution2(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 0) + 1);
        }
        for(int i = 0; i < participant.length; i++) {
            if(map.get(participant[i]) == null || map.get(participant[i]) == 0)
                return participant[i];

            map.put(participant[i], map.get(participant[i])-1);
        }

//        System.out.println(map.keySet());
//        System.out.println(map.entrySet());

        return map.entrySet().toString();
    }

    public String solution2(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 0) + 1);
        }
        for(int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.get(participant[i])-1);
        }

        for(String key: map.keySet()) {
            if(map.get(key) != 0) {
                return key;
            }
        }

        return map.entrySet().toString();
    }
}
