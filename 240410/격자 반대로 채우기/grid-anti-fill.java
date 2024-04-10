import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        int cnt = 1;

        for (int j=0; j<n; j++){
            if (j%2 != 0){
                for (int i=0; i<n; i++){
                    arr[i][n-1-j] = cnt++;
                }
            }
                
            else {
                for (int i=n-1; i>-1; i--){
                    arr[i][n-1-j] = cnt++;
                }
            } 
            
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }

    }
}