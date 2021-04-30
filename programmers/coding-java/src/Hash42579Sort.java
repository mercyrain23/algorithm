import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/42579

class Song implements Comparable<Song>{
    int idx;
    int cnt;

    public Song(int cnt, int idx) {
        this.cnt = cnt;
        this.idx = idx;
    }

    @Override
    public int compareTo(Song o) {
        if(o.cnt == this.cnt) {
            return this.idx - o.idx;
        }
        return o.cnt - this.cnt;
    }
}
public class Hash42579Sort {
    public static void main(String[] args) {
        Hash42579Sort T = new Hash42579Sort();

        String[] genres = {"classic", "bb", "cc", "pop", "classic", "classic", "pop", "pop", "aa"};
        int[] plays = {500, 200, 6000, 600, 150, 800, 2500, 2500, 100};

        int[] result = T.solution(genres, plays);
        for(int i: result) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

//        Map<String, Integer> genreMap = new TreeMap<>(Collections.reverseOrder());
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, ArrayList<Song>> songMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);

            if(songMap.get(genres[i]) != null) {
                ArrayList<Song>  list = songMap.get(genres[i]);
                list.add(new Song(plays[i], i));
                songMap.put(genres[i], list);
            } else {
                ArrayList<Song>  list = new ArrayList<>();
                list.add(new Song(plays[i], i));
                songMap.put(genres[i], list);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        List<String> keySet = new ArrayList<>(genreMap.keySet());
//        keySet.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));
        Collections.sort(keySet, (o1, o2) -> (genreMap.get(o2).compareTo(genreMap.get(o1))));
        for (String key : keySet) {
//            System.out.println(String.format("Key : %s, Value : %s", key, genreMap.get(key)));

            ArrayList<Song> songs = songMap.get(key);
            Collections.sort(songs);
            int cnt = 0;
            for(Song song: songs) {
                if(cnt >= 2) {
                    break;
                }
//                System.out.println(key + " " + song.idx + " " + song.cnt);
                result.add(songs.get(cnt++).idx);
            }
        }

        answer = new int[result.size()];
        int idx = 0;
        for(Integer num: result) {
            answer[idx++] = num;
        }
//        for(Map.Entry<String, Integer> map: genreMap.entrySet()) {
//            System.out.println(map.getKey() + " " + map.getValue());
//        }
//        System.out.println();

        return answer;
    }
}
