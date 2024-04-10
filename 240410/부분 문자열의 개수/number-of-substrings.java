import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();
        int cnt = 0;

        for (int j=0;j<A.length()-B.length()+1;j++){
            if (A.substring(j, j+B.length()).equals(B)){
                cnt++;
            }
        }

        System.out.print(cnt);

    }
}