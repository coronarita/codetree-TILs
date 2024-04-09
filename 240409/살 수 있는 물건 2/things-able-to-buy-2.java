import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = "";
        // 살 수 있는 가장 비싼 물건
        if (n>=3000) s = "book";
        else if (n>=1000) s = "mask";
        else if (n>=500) s = "pen";
        else s = "no";

        System.out.print(s);

        
    }
}