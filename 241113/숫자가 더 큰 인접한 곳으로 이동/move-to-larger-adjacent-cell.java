import java.util.*;
import java.io.*;

public class Main {
    static int N, R, C;
    static int[][] map;
    // 상, 하, 좌, 우 
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        R = sc.nextInt() - 1;
        C = sc.nextInt() - 1;

        map = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        while(true){
            boolean check = false;
            sb.append(map[R][C] + " ");

            for(int i=0; i<4; i++){
                int ny = R + dy[i];
                int nx = C + dx[i];

                if(!isInrange(nx, ny)) continue;

                if(map[ny][nx] > map[R][C]) {
                    check = true;
                    R += dy[i];
                    C += dx[i];
                    break;
                }
            }

            if(!check) break;
        }

        System.out.println(sb.toString());
    }

    public static boolean isInrange(int x, int y){
        return x>=0 && y >= 0 && x < N && y < N;
    }
}