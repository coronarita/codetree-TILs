import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = nextInt();
        int b = nextInt();

        if (a > b) System.out.print(a*b);
        else System.out.print(b/a);

    }
}