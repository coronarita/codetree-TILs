import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] strArr = sc.next().split(".");
        System.out.printf(strArr[2]+'.'+strArr[1]+'.'+strArr[0]);
    }
}