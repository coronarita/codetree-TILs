import java.util.*;

public class Main {
    public static int n;
    public static int[][] arr = new int[n][n];

    public static boolean inRange(int x, int y){
        return 0<=x&&x<n&&0<=y&&y<n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;

        int[] dxs = new int[]{0,1,0,-1};
        int[] dys = new int[]{1,0,-1,0};

        for (int x=0; x<n; x++){
            for (int y=0; y<n; y++){
                int adj = 0; 
                for (int d=0; d<4; d++){
                    int nx = x +dxs[d];
                    int ny = y + dys[d];

                    if (!inRange(nx, ny)) continue;
                    if (arr[nx][ny]==1) adj++;
                }
                if (adj >=3)cnt++;
                
            }
        }

        System.out.print(cnt);
    }
}