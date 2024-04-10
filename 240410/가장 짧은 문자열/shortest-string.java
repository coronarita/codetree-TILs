import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        String[] strArr = new String[3];
        int maxIdx = -1, minIdx = -1;
        int maxLen = -1, minLen = 99999;

        for (int i=0;i<3;i++){
            strArr[i] = sc.next();
            if (strArr[i].length() > maxLen){
                maxLen = strArr[i].length();
                maxIdx = i;
            }
            
            if (strArr[i].length() < minLen){
                minLen = strArr[i].length();
                minIdx = i;
            }

        }

        System.out.print(maxLen-minLen);

    }
}