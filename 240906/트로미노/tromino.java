import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, result = 0;
    public static int[][] map;
    // 첫번째 블록 체크 / 첫번째 좌표 기준 / y, x좌표
    public static int[][][] block1DxDy = {
        {{0, 0}, {1, 0}, {1, 1}}, //ㄴ
        {{1, 0}, {1, 1}, {0, 1}}, 
        {{0, 0}, {0, 1}, {1, 1}}, //ㄱ
        {{0, 1}, {0, 0}, {1, 0}}
    };

    // 두번쨰 블록 / 첫번째 좌표 기준 / y, x좌표
    public static int[][][] block2DxDy = {
        {{0,0}, {0, 1}, {0, 2}}, 
        {{1, 0}, {1, 1}, {1, 2}}, 
        {{2, 0}, {2, 1}, {2, 2}}, // 행
        {{0, 0}, {1, 0}, {2, 0}}, 
        {{0, 1}, {1, 1}, {2,1}}, 
        {{0, 2}, {1, 2},{2, 2}}  // 열
    };

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        // 2x2 정사각형 탐색
        for(int i=0; i<=n-2;i++){
            for(int j=0; j<=n-2; j++){
                int sx = j, sy = i;

                searchBlock1(sx, sy);
            }
        }
        

        // 3x3 정사각형 탐색
        for(int i=0; i<=n-3;i++){
            for(int j=0; j<=n-3; j++){
                int sx = j, sy = i;

                searchBlock2(sx, sy);
            }
        }

        System.out.print(result);
    }

    public static void searchBlock1(int sx, int sy) {
        for(int[][] blocks : block1DxDy) {
            int tempCnt = 0;

            for(int[] dxdy : blocks) {
                int nx = sx + dxdy[1];
                int ny = sy + dxdy[0];

                tempCnt += map[ny][nx];
            }

            result = Math.max(tempCnt, result);
        }
    }

    public static void searchBlock2(int sx, int sy) {
        for(int[][] blocks : block2DxDy) {
            int tempCnt = 0;

            for(int[] dxdy : blocks) {
                int nx = sx + dxdy[1];
                int ny = sy + dxdy[0];

                tempCnt += map[ny][nx];
            }

            result = Math.max(tempCnt, result);
        }
    }

}