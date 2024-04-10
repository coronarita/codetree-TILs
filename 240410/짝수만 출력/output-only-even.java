import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();       
        int b = sc.nextInt();       
 
        do {
            if (a%2==0)
                System.out.print(a +" ");
            a++;
        }while (a<=b);

    }
}