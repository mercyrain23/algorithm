import java.util.*;

public class Sort42746 {

    public static void main(String[] args) {
        Sort42746 T = new Sort42746();

//        int[] numbers = {6, 10, 2};
//        int[] numbers = {3, 30, 34, 5, 9};
        int[] numbers = {0, 0, 0, 0, 0};

        System.out.println(T.solution(numbers));
    }

    public String solution(int[] numbers) {
        String answer = "";

        Integer[] arr = new Integer[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            arr[i] = numbers[i];
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer num1 = Integer.valueOf(o1.toString() + o2.toString());
                Integer num2 = Integer.valueOf(o2.toString() + o1.toString());
                return num2 - num1;

//                String tmp1 = o1.toString();
//                String tmp2 = o2.toString();
//                return (tmp2+tmp1).compareTo(tmp1+tmp2);
            }
        });

        StringBuilder st = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            st.append(arr[i]);
        }
        answer = st.toString();

        if("0".equals(answer.substring(0, 1))) {
            return "0";
        }

        //System.out.println(Arrays.toString(arr));
        return answer;
    }

    public String solution2(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return Integer.compare(Integer.parseInt(bs+as), Integer.parseInt(as+bs));
        });

        StringBuilder sb = new StringBuilder();
        for(Integer i: list) {
            sb.append(i);
        }

        answer = sb.toString();
        if (answer.charAt(0) == '0') {
            return "0";
        } else {
            return answer;
        }
    }
}

