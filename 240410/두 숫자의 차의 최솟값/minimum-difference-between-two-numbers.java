import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MIN_VAL = Integer.MAX_VALUE;

        int n = sc.nextInt();
        int[] arr = new int[n];
        int ans = MIN_VAL;

        for (int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (i==j) continue;
                if (ans > arr[j] - arr[i])
                    ans = arr[j] - arr[i]; // 오름차순 가정 

            }
        }
        System.out.printf("%d",ans);
        
    }
}