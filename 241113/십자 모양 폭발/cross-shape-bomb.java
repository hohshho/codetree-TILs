import java.util.*;
import java.io.*;

public class Main {
    static int N, by, bx;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        by = sc.nextInt() - 1;
        bx = sc.nextInt() - 1;

        bomb();

        move();

        for(int[] row : map){
            for(int item : row){
                System.out.print(item + " ");
            }
            System.out.println("");
        }
    }

    public static void bomb() {
        int cnt = map[by][bx] - 1;
        map[by][bx] = 0;
        if(cnt == 0) return;

        for(int i=0; i<4; i++){
            int nx = bx;
            int ny = by;
            for(int j=0; j<cnt; j++){
                nx += dx[i];
                ny += dy[i];

                if(!isInrange(nx, ny)) continue;

                map[ny][nx] = 0;
            }
        }
    }

    public static void move() {
        int[][] tempMap = new int[N][N];

        for(int j=0; j<N; j++){ // x
            int tempIdx = N-1;
            for(int i=N-1; i>=0; i--){ // y
                if(map[i][j] == 0) continue;

                tempMap[tempIdx--][j] = map[i][j];
            }
        }

        map = tempMap;
    }

    public static boolean isInrange(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}