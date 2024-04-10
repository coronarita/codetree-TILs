import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = 0;
        int[] nArr = new int[b]; // Save mod

        while (a>1){
            nArr[a%b] += 1;
            a/=b;
        }

        for (int i=0; i<b; i++){
            // System.out.println(nArr[i]);
            sum += nArr[i]*nArr[i];
        }
        System.out.print(sum);

    }
}