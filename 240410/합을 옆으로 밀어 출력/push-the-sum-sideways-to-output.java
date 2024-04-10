import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int n = sc.nextInt();
        int tot = 0;
        for (int i=0;i<n; i++)
            tot += sc.nextInt();

        // 좌측으로 한칸 민 값을 출력
        String s = Integer.toString(tot);
        System.out.print(s.substring(1)+s.substring(0,1));
    }   
}