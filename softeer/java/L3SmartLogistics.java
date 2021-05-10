import java.util.Scanner;

/*
20 1
HHPHPPHHPPHPPPHPHPHP

=> 8

20 2
HHHHHPPPPPHPHPHPHHHP

=> 7
 */
public class L3SmartLogistics {
    public static void main(String[] args) {
        L3SmartLogistics T = new L3SmartLogistics();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String str = sc.next();
        int[] check = new int[str.length()+K];

        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'P') {

                for(int j = Math.max(0, i-K); j <= Math.min(N-1, i+K); j++) {
                    if(check[j] == 0 && str.charAt(j) == 'H') {
                        check[j] = 1;
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
