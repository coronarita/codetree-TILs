import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1= sc.next();
        String s2= sc.next();

        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        String ns1 = "";
        String ns2 = "";

        for (int i=0; i<cs1.length;i++){
            // 알파벳은 제외
            if (('a' <= cs1[i] && cs1[i] <= 'z') || ('A' <= cs1[i] && cs1[i] <= 'Z')) continue;
            ns1 += cs1[i];
        }

        for (int i=0; i<cs2.length;i++){
            // 알파벳은 제외
            if (('a' <= cs2[i] && cs2[i] <= 'z') || ('A' <= cs2[i] && cs2[i] <= 'Z')) continue;
            ns2 += cs2[i];
        }

        System.out.print(Integer.parseInt(ns1)+Integer.parseInt(ns2));
    }
}