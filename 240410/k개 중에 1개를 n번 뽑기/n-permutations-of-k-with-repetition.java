import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int n = -1, k = -1;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void choose(int currNum){
        if (currNum==n){
            print();
            return;
        }

        for (int i=1; i<=k; i++){
            arr.add(i);
            choose(currNum+ 1);
            arr.remove(arr.size()-1);
        }

    }
    public static void print(){
        for (int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        choose(0);


    }
}