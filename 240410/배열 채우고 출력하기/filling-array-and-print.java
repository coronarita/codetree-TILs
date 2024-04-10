import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cArr = new char[10];

        for (int i=0; i<10; i++){
            char c = sc.next().charAt(0);
            cArr[i] = c;
        }

        for (int i=0; i<10; i++){
            System.out.print(cArr[9-i]);
        }
    }
}