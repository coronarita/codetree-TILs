import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int idx = -1;

        String s = sc.next();

        for (int i=0; i<s.length();i++){
            if (s.charAt(i) == 'e'){
                idx = i;
                break;
            }
        }

        s = s.substring(0, idx) + s.substring(idx+1);
        System.out.println(s);
    }
}