import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int len = str.length();
        for (int i=len-1;i>-1;i--){
            if ((len-1 - i)%2 != 0) continue;
            System.out.print(str.charAt(i));
        }

    }
}