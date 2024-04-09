import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a1 = sc.nextInt();
        char b1 = sc.next().charAt(0);
        int a2 = sc.nextInt();
        char b2 = sc.next().charAt(0);
        // 두 사람 중 한사람이라도 19세 이상, 남자라
        // (a1 >= 19&& b1=="M") || (a2 >=19 && b2=="M")
        // 

        System.out.println((a1 >= 19&& b1=='M') || (a2 >=19 && b2=='M')?1:0);

        
    }
}