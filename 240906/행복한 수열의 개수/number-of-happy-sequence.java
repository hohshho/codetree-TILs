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
            int tempCnt = 1;
            for(int i=1; i < n; i++) {
                if(map[line][i-1] == map[line][i]) tempCnt += 1;
                else tempCnt = 1;

                sameCntMax = Math.max(tempCnt, sameCntMax);
                if(sameCntMax >= m) return true;
            }
        }
        else if (mode == 1) {
            // x값 고정
            int tempCnt = 1;
            for(int i=1; i < n; i++) {
                if(map[i-1][line] == map[i][line]) tempCnt += 1;
                else tempCnt = 1;

                sameCntMax = Math.max(tempCnt, sameCntMax);
                if(sameCntMax >= m) return true;
            }
        }

        if(sameCntMax >= m) return true;
        else return false;
    }
}