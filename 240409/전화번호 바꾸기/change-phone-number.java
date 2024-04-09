import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] StrArr = sc.next().split("-");
        System.out.println(StrArr[0]+'-'+StrArr[2]+'-'+StrArr[1]);
    }
}