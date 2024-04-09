import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int div = a / b;
        int mod = a % b;

        System.out.printf(div+"..."+mod);
    }
}