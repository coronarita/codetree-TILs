import java.util.*;

public class Main {
    public static int INT_MIN = Integer.MIN_VALUE;
    public static int INT_MAX = Integer.MAX_VALUE;
    public static int OPERATOR_NUM = 3;
    public static int MAX_NUM = 11;

    public static int n;
    public static int[] numbers = new int[MAX_NUM];
    public static int[] operatorCnt = new int[OPERATOR_NUM];
    public static int minVal = INT_MAX, maxVal = INT_MIN;
    public static ArrayList<Integer> operators = new ArrayList<>();
    
    // 값을 반환
    public static int calculate(){
        int val = numbers[0];

        for (int i=0; i<operators.size(); i++){
            if (operators.get(i) == 0)
                val += numbers[i + 1];
            else if (operators.get(i) == 1)
                val -= numbers[i + 1];
            else 
                val *= numbers[i + 1];
        }   

        return val;
    }


    // 연산자 초과여부 판별
    public static boolean isAvailable(){
        for (int i=0; i<OPERATOR_NUM; i++){
            if (operatorCnt[i] < 0)
            return false;
        }
        return true;
    }

    // 정답 갱신
    public static void findMinAndMax(int cnt){
        if (cnt == n - 1){
            if (isAvailable()){
                int val = calculate();
                minVal = Math.min(minVal, val);
                maxVal = Math.max(maxVal, val);
            }

            return;
        }

        for (int i=0; i < OPERATOR_NUM; i++){
            operators.add(i);
            operatorCnt[i]--;

            findMinAndMax(cnt +1);
            operators.remove(operators.size()-1);
            operatorCnt[i]++;
        }
    }
    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        
        for (int i=0; i<n; i++){
            numbers[i] = sc.nextInt();
        }

        for (int i=0; i<OPERATOR_NUM; i++){
            operatorCnt[i] = sc.nextInt();
        }

        findMinAndMax(0);

        System.out.print(minVal + " " + maxVal);
        
    }
}