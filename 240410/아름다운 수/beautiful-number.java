import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int n, cnt;
    public static ArrayList<Integer> selected = new ArrayList<>();

    public static boolean satisfied(){
        // selected를 검사합니다.
        int prv_num = 0;
        int _cnt = 1;

        for (int i=0; i<selected.size();i++){
            int i_num = selected.get(i);
    
            if (_cnt == i_num) {
                prv_num = selected.get(i);
                _cnt = 1;
                continue;
            }
            // i_num이 이전과 다르다.
            if (selected.get(i) != prv_num){
                if (_cnt != prv_num) return false;
                else {
                    prv_num = selected.get(i);
                    cnt = 1;
                }
                
            }
            else { // 같다.
                // 2부터는 검사를 해야 됨
                prv_num = selected.get(i);
                _cnt++;
            }


        }
        
        return true;
    }

    public static void backtracking(int currNum){
        if (currNum == n){
            // System.out.println(selected);
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