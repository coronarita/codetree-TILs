import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int n, cnt;
    public static ArrayList<Integer> selected = new ArrayList<>();

    public static boolean satisfied(){
        // selected를 검사합니다.
        int cur = 0;
        
        for (int i=0; i<selected.size();i++){
            int i_num = selected.get(i);
            // i_num이 출현 할 때 검사
            if (i_num == 1) continue;
            // 2부터는 검사를 해야 됨
            int _cnt = 0;
            for (int j=i; j<i+i_num;j++){
                if (j >= selected.size()) return false;
                if (selected.get(j) == i_num) _cnt++;
            }
            if (_cnt != i_num) break;

            // System.out.println();
            

        }
        
        return true;
    }

    public static void backtracking(int currNum){
        if (currNum == n){
            if (satisfied()){
                cnt++;
            }
            return;
        }

        for (int i=1; i<5; i++){
            selected.add(i);
            backtracking(currNum+1);
            selected.remove(selected.size()-1);
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        backtracking(0);
        System.out.print(cnt);
    }
}