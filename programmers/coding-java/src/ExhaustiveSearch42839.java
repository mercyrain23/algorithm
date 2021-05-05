// 소수 찾기

import java.util.HashSet;

public class ExhaustiveSearch42839 {
    int[] check;
    int N;
    HashSet<Integer> set;

    public static void main(String[] args) {
        ExhaustiveSearch42839 T = new ExhaustiveSearch42839();

        String str1 = "17";
        String str2 = "011";

        System.out.println(T.solution(str1));
        System.out.println(T.solution(str2));
    }
    public int solution(String numbers) {
        int answer = 0;

        char[] arr = numbers.toCharArray();
        N = arr.length;
        check = new int[N];
        set = new HashSet<>();

        String str = "";
        DFS(0, str, arr);

        //Integer[] result = new Integer[set.size()];
        //set.toArray(result);
        //Arrays.sort(result);

        //System.out.println(Arrays.toString(result));

        answer = set.size();
        return answer;
    }

    public void DFS(int L, String str, char[] arr) {
        if(L == arr.length) {
            return;
        } else {
            for(int i = 0; i < N; i++) {
                if(check[i] == 0) {
                    check[i] = 1;
//                    System.out.println(str + arr[i]);
                    if(isPrime(Integer.parseInt(str + arr[i]))) {
                        set.add(Integer.parseInt(str + arr[i]));
                    }
                    DFS(L + 1, str + arr[i], arr);
                    check[i] = 0;
                }

            }
        }
    }

    boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) { // 소수 구하기
            if(num % i == 0) return false;
        }
        return true;
    }

}
