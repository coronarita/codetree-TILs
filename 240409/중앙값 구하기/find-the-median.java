import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int ans = -1;

        if (a > b){
            if (b > c){ // a > b > c
                ans = b;
            } else { // b > a
                if (a > c) { // b > a > c
                    ans = c;
                } else {
                    ans = a;
                }
                    
            }
        }
        else { // b > a
            if (b > c){
                if (a > c) {
                    ans = a;
                } else // c > a
                    ans = c;
                } 
                else { // c > b
                ans = b;
           }
       }
       System.out.print(ans);
    }
}