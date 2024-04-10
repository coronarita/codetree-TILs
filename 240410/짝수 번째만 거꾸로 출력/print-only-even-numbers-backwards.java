import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int len = str.length();
        String ans = "";

        for (int i=0;i<len;i++){
            if (i%2!=0) ans = str.charAt(i) + ans;
        }

        System.out.print(ans);
    }
}