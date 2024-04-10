import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int len = s.length();
        String cs = sc.next();
        char[] cmd = cs.toCharArray();

        for (int i=0; i<cmd.length;i++){
            if (cmd[i] == 'L'){
                s = s.substring(1) + s.substring(0, 1);
            }
            else if(cmd[i] == 'R') { // 'R'
                s = s.substring(len-1) + s.substring(0, len-1);
            }
            
        }

        System.out.println(s);

    }
}