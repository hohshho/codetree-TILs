import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt() - 1;

        map = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        if(N == 1) {
            System.out.println(1);
            return;
        }

        int line = 0;
        while(true){
            // K, K+1, K+2
            boolean check = true;

            for(int i=K; i<K+M; i++){
                if(map[line][i] == 1) check = false;
            }
            
            // 전 라인에 1추가
            if(!check) {
                line -= 1;
                for(int i=K; i<K+M; i++){
                    map[line][i] = 1;
                }
                break;
            }
            else {
                line += 1;
            }
        }

        for(int[] row : map){
            for(int item : row){
                System.out.print(item + " ");
            }
            System.out.println();
        }


    }
}