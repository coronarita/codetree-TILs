import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1시간 뒤의 시간을 출력
        // int[] timeArr = sc.next().split(":");

        // System.out.printf("%d:%d", timeArr[0]+1, timeArr[1]);
        sc.useDelimiter(":");
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        System.out.println(a+1 + ":" + b);


    }
}