import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[][] map;
    public static int result = 0;
    
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        for(int i = 0; i < n; i++) {
            // 가로 (행)
            if(check(i, 0)) result += 1;

            // 세로 (열)
            if(check(i, 1)) result += 1;
        }

        System.out.println(result);
    }

    public static boolean check(int line, int mode) {
        int sameCntMax = 1;
        if(mode == 0) {
            // y값 고정
            int prev = map[line][n-1];
            int tempCnt = 1;
            for(int i=n-2; i >=0; i--) {
                if(prev == map[line][i]) tempCnt += 1;
                else tempCnt = 1;

                prev = map[line][i];
                sameCntMax = Math.max(tempCnt, sameCntMax);
            }
        }
        else if (mode == 1) {
            // x값 고정
            int prev = map[n-1][line];
            int tempCnt = 1;
            for(int i=n-2; i >=0; i--) {
                if(prev == map[i][line]) tempCnt += 1;
                else tempCnt = 1;

                prev = map[i][line];
                sameCntMax = Math.max(tempCnt, sameCntMax);
            }
        }

        if(sameCntMax >= m) return true;
        else return false;
    }
}