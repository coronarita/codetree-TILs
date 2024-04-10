import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] iArr = new int[n];

    for (int i=0; i<n; i++){
        iArr[i] = sc.nextInt();
    }
    for (int i=n-1; i>-1; i--){
        if (iArr[i]%2 == 0) System.out.print(iArr[i] + " ");
    }       

    }
}