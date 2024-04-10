import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] sArr = new String[n];
        int[] cntArr = new int[n];
        int cnt = 0;

        for (int i=0; i<n; i++){
            sArr[i] = sc.next();
        }
        char cond = sc.next().charAt(0);

        for (int i=0; i<n; i++){
            if (sArr[i].charAt(0)==cond){
                cntArr[i] = sArr[i].length();
                cnt++;
            }
        }
        int tot = 0;
        for (int i=0;i<n; i++){
            tot += cntArr[i];
        }
        System.out.print(cnt + " ");
        System.out.printf("%.2f", ((double)tot/cnt));
    }
}