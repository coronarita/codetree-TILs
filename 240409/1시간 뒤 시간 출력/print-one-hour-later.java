import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1시간 뒤의 시간을 출력
        String[] timeArr = sc.next().split(":");

        System.out.printf("%d:%d", int(timeArr[0])+1, int(timeArr[1]));
                

    }
}