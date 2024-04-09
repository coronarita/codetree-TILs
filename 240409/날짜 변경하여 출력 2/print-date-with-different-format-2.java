import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        sc.useDelimiter("-");
        m = sc.nextInt();
        d = sc.nextInt();
        y = sc.nextInt();

        System.out.printf("%d.%d.%d",y,m,d);

    }
}