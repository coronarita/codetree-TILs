import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] cArr = new char[5][3];

        for (int i=0;i<5;i++)
            for (int j=0;j<3;j++)
                cArr[i][j] = sc.next().toUpperCase().charAt(0);

        for (int i=0;i<5;i++){
            for (int j=0;j<3;j++){
            System.out.print(cArr[i][j] + " ");
            }
            System.out.println();
        }
            

    }
}