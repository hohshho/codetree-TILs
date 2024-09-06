import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=n-3; j++) {
                int tempCnt = check(j, i);

                result = Math.max(tempCnt, result);
            }
        }

        System.out.println(result);
    }

    public static int check(int x, int y) {
        int cnt = 0;
        for(int i = y; i < y+3; i++){
            for(int j = x; j < x+3; j++) {
                if(map[i][j] == 1) cnt += 1;
            }
        }
        return cnt;
    }
}