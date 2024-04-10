import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        // 앞에서 2, 뒤에서 2를 'a'로 대체하기
        // 1, arr.length-2
        char[] arr = s.toCharArray();
        
        arr[1] = 'a';
        arr[arr.length-2] = 'a';

        s = String.valueOf(arr);

        System.out.print(s);
    }
}