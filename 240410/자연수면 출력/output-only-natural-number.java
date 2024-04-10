import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int cnt = 0;
        
        if (a>0){
            while (cnt < b ){
            System.out.print(a);
            cnt++;
            }
        } else
            System.out.println(0);
        
        
    }
}