import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int n, cnt;
    public static ArrayList<Integer> selected = new ArrayList<>();

    public static boolean satisfied(){
        // selected를 검사합니다.
        // 연달아 같은 숫자가 나오는 시작 위치를 잡습니다.
        for(int i = 0; i < n; i += selected.get(i)) {
            // 만약 연속하여 해당 숫자만큼 나올 수 없다면
            // 아름다운 수가 아닙니다.
            if(i + selected.get(i) - 1 >= n)
                return false;
            // 연속하여 해당 숫자만큼 같은 숫자가 있는지 확인합니다.
            // 하나라도 다른 숫자가 있다면
            // 아름다운 수가 아닙니다.
            for(int j = i; j < i + selected.get(i); j++)
                if(selected.get(j) != selected.get(i))
                    return false;
        }
        
        return true;
    }

    public static void backtracking(int currNum){
        if (currNum == n){
            
            if (satisfied()){
                // System.out.println(selected);
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