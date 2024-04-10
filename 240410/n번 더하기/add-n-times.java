import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int n = sc.nextInt();

        // a에 n을 더하는 과정을 n번 반복

        int cnt = 0;
        while (cnt < n ){
            a += n;
            System.out.println(a);
            cnt++;
        }
        
    }
}