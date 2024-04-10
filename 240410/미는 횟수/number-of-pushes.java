import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        int len = s1.length();
        int cnt = 0;

        for (int i=0; i<len; i++){
            if (s1.equals(s2))break;            
            s1 = s1.substring(len-1) + s1.substring(0, len-1);
            cnt++;
        }

        if (cnt >= len) cnt = -1;
        System.out.print(cnt);
    }
}