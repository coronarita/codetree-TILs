import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        System.out.print(a>b?1:0);
        System.out.print(a>c?1:0);
        System.out.print(a>d?1:0);
        System.out.print(a>e?1:0);

        
    }
}