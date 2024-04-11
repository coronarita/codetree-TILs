import java.util.*;

public class Main {
    public static int n = -1;
    // W S N E

    public static HashMap<Character, Integer> dNum = new HashMap<>();
    public static int[] dys = new int[]{-1, 0, 0, 1};
    public static int[] dxs = new int[]{0, 1, -1, 0};
    public static int x = 0;
    public static int y = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dNum.put('W',0);
        dNum.put('S',1);
        dNum.put('N',2);
        dNum.put('E',3);

        for (int i=0; i<n; i++){
            char dir = sc.next().charAt(0);
            // System.out.print(dir);

            int dist = sc.nextInt();
            int dIdx = dNum.get(dir);
            
            x += dxs[dIdx]*dist;
            y += dys[dIdx]*dist;

        }
        System.out.printf("%d %d\n", y, -x);   
    }

}