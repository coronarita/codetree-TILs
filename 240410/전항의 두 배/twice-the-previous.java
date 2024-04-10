import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 10번째 항 까지 구하기
        // A_n = A_n-1 + 2*A_n-2

        int[] arr = new int[10];

        arr[0] = sc.nextInt();        
        arr[1] = sc.nextInt();        
        
        for (int i=2; i<10; i++){
            arr[i] = arr[i-1] + 2* arr[i-2];
        }
        for (int i=0; i<10; i++)
            System.out.print(arr[i]+" ");
        
    }
}