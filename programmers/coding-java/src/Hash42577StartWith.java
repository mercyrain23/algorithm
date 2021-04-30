import java.util.Arrays;

public class Hash42577StartWith {
    public static void main(String[] args) {
        Hash42577StartWith T = new Hash42577StartWith();

        String[] str1 = {"119", "97674223", "1195524421"};
        String[] str2 = {"123","456","789"};
        String[] str3 = {"12","123","1235","567","88"};

        System.out.println(T.solution(str1));
        System.out.println(T.solution(str2));
        System.out.println(T.solution(str3));
    }

    // 정확성(83.3) 효율성(16.7)
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i = 1; i < phone_book.length; i++) {
            if(phone_book[i].startsWith(phone_book[i-1]))
                return false;
//            System.out.println(phone_book[i]);
        }
        return true;
    }

    /*
    public boolean solution(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
    */
}
